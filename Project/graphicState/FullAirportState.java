package graphicState;

import drawingtool.Airport;

public class FullAirportState extends State {

	private FullAirportState(Airport context) {
		this.context = context;
		fullAirport = this;
	}

	public State getInstance(Airport context) {
		if (fullAirport == null) {
			fullAirport = new FullAirportState(context);
		}
		context.setAllPlanes();
		return fullAirport;
	}

	@Override
	public State setFullAirport() {
		System.out.println("You are already in the FullAirport State!");
		return this;
	}

	@Override
	public State setColouredTails() {
		System.out.println("State change! From FullAirport to ColouredTails");
		context.colorTails();
		return ColouredTailState.getInstance(context);

	}

	@Override
	public State setColouredBody() {
		System.out.println("State change! From FullAirport to ColouredBody");
		context.colorPlanes();
		return ColouredBodyState.getInstance(context);
	}

	@Override
	public State setFullyColoured() {
		System.out.println("State change! From FullAirport to FullyColoured");
		context.colorPlanes();
		context.colorTails();
		return FullyColouredState.getInstance(context);

	}

	@Override
	public State setEmptyAirport() {
		System.out.println("State change! From FullAirport to EmptyAirport");
		context.setTerminal();
		return EmptyAirportState.getInstance(context);
	}

}
