package de.hsos.api.boundary.rest;

import de.hsos.api.control.ItemManagement;
import de.hsos.api.shared.dto.ItemCreationDTO;
import de.hsos.api.shared.dto.ItemDTO;
import de.hsos.api.shared.dto.ItemUpdateDTO;
import de.hsos.api.shared.dto.PriceDTO;
import de.hsos.api.shared.id.IdGenerationQualifier;
import de.hsos.api.shared.id.IdGenerationType;
import de.hsos.api.shared.id.ItemIdGenerator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;

@Path("/items")
@ApplicationScoped
public class ItemResource {

    @Inject
    ItemManagement itemManagement;

    /*
    @Inject
    @IdGenerationQualifier(type = IdGenerationType.ITEM)
    ItemIdGenerator idGenerator;
    */


    /**
     * (GET) http://localhost:8080/items
     *
     * @return 200 OK , a Response of a Collection of all Items in the Database.
     * The Data is converted to a Data Transfer Object with following fields:  description, shortDescription, price, promoPriceDTO, barcodeDTO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllItems() {
        return Response.ok(this.itemManagement.getAllItems()).build();
    }

    /**
     * RequestUrl: (GET) http://localhost:8080/items/{id}
     *
     * Gets a specific ItemDTO with the ID of the Item
     *
     * @param id ID of the Item you wish to get.
     * @return 200 Ok if the Items exists || 204 NoContent if the Items does not existsItemDTO.
     * Response Body contains following fields: description, shortDescription, price, promoPriceDTO, barcodeDTO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getItemById(@PathParam("id") Long id) {

        ItemDTO itemDTO = this.itemManagement.getItem(id);

        if (itemDTO != null) {

            return Response.ok(itemDTO).build();
        } else {

            return Response.noContent().build();
        }
    }

    /**
     * RequestUrl: (Post) http://localhost:8080/items
     *
     * Creates a new Item. You need to parse a JSON Object with following properties.
     *
     * @param itemCreationDTO accepting a JSON Object:
     * {
     *   "description": "string",
     *   "shortDescription": "string",
     *   "barcodeDTO": {
     *     "barcode": "string"
     *   },
     *   "priceDTO": {
     *     "price": 0,
     *     "effectiveDate": "2022-03-10"
     *   },
     *   "promoPriceDTO": {
     *     "expirationDate": "2022-03-10",
     *     "discountPrice": 0
     *   }
     * }
     *
     * @return 200 OK if the creation of new Item was successful || 204 NoContent if  the creation of new Item was not successful
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createItem(ItemCreationDTO itemCreationDTO) {

        if (this.itemManagement.createItem(itemCreationDTO)) {
            return Response.ok().build();
        } else {
            return Response.noContent().build();
        }


    }

    /**
     * RequestUrl: (PUT) http://localhost:8080/items/{id}
     *
     * Updates an existing Item. You need to parse the ID of the item you wish to modify and a JSON object with the adjusted values.
     *
     * @param id ID of the Item you wish to modify.
     * @param itemUpdateDTO accepting a JSON Object:
     * {
     *   "description": "string",
     *   "shortDescription": "string",
     *   "priceDTO": {
     *     "price": 0,
     *     "effectiveDate": "2022-03-10"
     *   },
     *   "promoPriceDTO": {
     *     "expirationDate": "2022-03-10",
     *     "discountPrice": 0
     *   }
     * }
     *
     * @return 200 Ok if the modification/updating of Item was successful || 304 if the modification/updating of Item was NOT successful
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateItem(@PathParam("id") Long id, ItemUpdateDTO itemUpdateDTO) {

        if (this.itemManagement.updateItem(id, itemUpdateDTO)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }

    /**
     * RequestUrl: (DELETE) http://localhost:8080/items/{id}
     *
     * Delete an existing Item by id.
     *
     * @param id ID of the Item you wish to delete.
     * @return 200 Ok if delete was successful || 204 NoContent if delete was not successful.
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteItem(@PathParam("id") Long id) {

        if (this.itemManagement.deleteItem(id)) {
            return Response.ok().build();
        } else {
            return Response.noContent().build();
        }
    }


    /**
     *  RequestUrl: (POST) http://localhost:8080/items/{id}/getPriceForDate
     *
     *
     * calculates either promotional price or normal price, which depends on the incoming date
     *
     * @param id id of the Item
     * @param date e.g. "2022-03-10" : Date with which you want to determine the price.
     * @return 200 OK if Item id exists || 203 NoContent if Item id does not exist.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/getPriceForDate")
    public Response getPriceForDate(@PathParam("id") Long id, Date date) {

        PriceDTO priceDTO = this.itemManagement.getPriceForDate(id, date);

        if (priceDTO != null) {
            return Response.ok(priceDTO).build();
        } else {
            return Response.noContent().build();
        }
    }

    /**
     * RequestUrl: http://localhost:8080/items/{id}/{qty}
     *
     * Calculates total Cost considering the Item and the amount of the Item.
     *
     * @param id ID of the Item.
     * @param qty Quantity of the Item.
     * @return 200 OK - you get back a price DTO with the total cost and the effective date. || 204 NoContent if the item was not found.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/{qty}")
    public Response howMuchForQty(@PathParam("id") Long id, @PathParam("qty") Integer qty) {

        PriceDTO priceDTO = this.itemManagement.howMuchForQty(id, qty);

        if (priceDTO != null) {
            return Response.ok(priceDTO).build();
        } else {
            return Response.noContent().build();
        }
    }
}