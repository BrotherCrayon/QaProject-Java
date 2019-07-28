package rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
		
		@POST
		@Path("/getAccountList/{accountId}")
		public String getAccountList(@PathParam("accountId") int accountId, int listId) {
			return this.service.getAccountList(accountId, listId);
		}
		
		@POST
		@Path("/createList/{accountId}")
		public String createList(String list, @PathParam("accountId") int accountId) {
			return this.createList(list, accountId);
		}
		
		@DELETE
		@Path("/delete/{listId}")
		public String deleteList(@PathParam("listId") int listId) {
			return this.service.deleteList(listId);
		}
		
		@POST
		@Path("/update/{listId}")
		public String updateList(@PathParam("listId")int listId, String lists) {
			return this.service.updateList(listId, lists);
		}
}