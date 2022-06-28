package graphicState;

import drawingtool.Airport;
public class ColouredBodyState extends State{

	private ColouredBodyState(Airport context) {
		this.context = context;
		colouredBody=this;
	}
	
	public static State getInstance(Airport context) {
		if(colouredBody==null) {
			colouredBody = new ColouredBodyState(context);
		}
		context.colorPlanes();
		return colouredBody;
	}
	
	@Override
	public State setFullAirport() {
		System.out.println("State change!From EmptyAirport to FullAirport");
		context.setAllPlanes();
		return fullAirport.setFullAirport();
	}

	@Override
	public State setColouredTails() {
		System.out.println("State change! From FullAirport to ColouredTails");
		context.colorTails();
		return ColouredTailState.getInstance(context);
	}

	@Override
	public State setColouredBody() {
		System.out.println("You are already in the ColouredBody State!");
		return this;
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
