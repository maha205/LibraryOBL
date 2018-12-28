package server;

import Utils.Request;
import Views.*;

public class Router {
	public Physicians physicians;

	public Router() {
		physicians = new Physicians();
	}

	public Object resolve(Request request) {
		switch (request.getView()) {
		case "physicians":
			return physicians.resolve(request);
		}
		return null;
	}
}