package rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import persistence.exceptions.AccountNotFoundException;
import service.ListService;

@Path("/todolist")
public class ListController {

		@Inject
		private ListService service;
		
		@GET
		@Path("/getAll")
		public String getAllLists() {
			return this.service.getAllLists();
		}
		
		@GET
		@Path("/getAccountList/{accountId}")
		public String getAccountList(@PathParam("accountId") int accountId) {
			try{
				return this.service.getAccountList(accountId);
			} catch (AccountNotFoundException anfe) {
				return "{ \"message\": \"Account not found\"}";
			}
		}
		
//		@POST
//		@Path("/createList/{accountId}")
//		public String createList(String list, @PathParam("accountId") int accountId) {
//			return this.createList(list, accountId);
//		}
		
		@POST
		@Path("/createListItem/{accountId}")
		public String createListItem(String list, @PathParam("accountId") int accountId) {
			return this.service.createListItem(list, accountId);
		}
		
		@DELETE
		@Path("/delete/{listId}")
		public String deleteList(@PathParam("listId") int listId) {
			return this.service.deleteList(listId);
		}
		
//		@POST
//		@Path("/update/{listId}")
//		public String updateList(@PathParam("listId")int listId, String lists) {
//			return this.service.updateList(listId, lists);
//		}
}