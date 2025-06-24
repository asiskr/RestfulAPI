package restAPI;

import java.util.List;
import java.util.Arrays;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/aliens")
public class AlienResource {

	AlienRepo repo = new AlienRepo();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Alien> getAlien() {

		System.out.println("Getting Method is called");

		return repo.getAliens();
	}
	
	@GET
	@Path("/alien/{id}")
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Alien getId(@PathParam("id")int id) {

		System.out.println("Getting Method is called");

		return repo.getAlien(id);
	}

	@Path("/alien")
	@POST
	@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Alien createAlien(Alien a1) {
		System.out.println(a1);
		repo.create(a1);
		return a1;
	}

}
