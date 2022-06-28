package graphicState;

import drawingtool.Airport;

public class EmptyAirportState extends State {

	private EmptyAirportState(Airport context) {
		this.context = context;
		emptyAirport = this;
	}

	public static State getInstance(Airport context) {
		if (emptyAirport == null) {
			emptyAirport = new EmptyAirportState(context);
		}
		context.setTerminal();
		return emptyAirport;
	}

	@Override
	public State setFullAirport() {
		System.out.println("State change!From EmptyAirport to FullAirport");
		context.setAllPlanes();
		return fullAirport.setFullAirport();
	}

	@Override
	public State setColouredTails() {
		// Not accesible fromthis point
		System.out.println("You first have to have planes, to go into the ColouredTails State!");
		return null;

	}

	@Override
	public State setColouredBody() {
		// Not accesible fromthis point
		System.out.println("You first have to have planes, to go into the ColouredBody State!");
		return null;
	}

	@Override
	public State setFullyColoured() {
		// Not accesible fromthis point
		System.out.println("You first have to have planes, to go into the FullyColoured State!");
		return null;
	}

	@Override
	public State setEmptyAirport() {
		System.out.println("You are already in the Empty Airport state!");
		return this;
	}

}
