package graphicState;
import drawingtool.Airport;
public class FullyColouredState extends State{
	
	private FullyColouredState(Airport context) {
		this.context = context;
		fullyColoured=this;
	}
	
	public static State getInstance(Airport context) {
		if(fullyColoured == null) {
			fullyColoured = new FullyColouredState(context);
		}
		context.colorPlanes();
		context.colorTails();
		
		return fullyColoured;
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
		System.out.println("State change! From FullAirport to ColouredBody");
		context.colorPlanes();
		return ColouredBodyState.getInstance(context);
	}

	@Override
	public State setFullyColoured() {
		System.out.println("You are already in the FullColoured State!");
		return this;
	}

	@Override
	public State setEmptyAirport() {
		System.out.println("State change! From FullAirport to EmptyAirport");
		context.setTerminal();
		return EmptyAirportState.getInstance(context);
	}

}
