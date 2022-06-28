package graphicState;
import drawingtool.Airport;
public class ColouredTailState extends State {

	private ColouredTailState(Airport context) {
		this.context = context;
		colouredTails=this;
	}
	
	public static State getInstance(Airport context) {
		if(colouredTails==null) {
			colouredTails = new ColouredTailState(context);
		}
		context.colorTails();
		return colouredTails;
	}
	
	@Override
	public State setFullAirport() {
		System.out.println("State change!From EmptyAirport to FullAirport");
		context.setAllPlanes();
		return fullAirport.setFullAirport();
	}

	@Override
	public State setColouredTails() {
		System.out.println("You are already in the ColouredTails State!");
		return this;
	}

	@Override
	public State setColouredBody() { //Same as fully coloured
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
