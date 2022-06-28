package graphicState;

import drawingtool.Airport;

public abstract class State {
	protected Airport context;

	protected static State emptyAirport, 
	fullAirport, 
	colouredTails, 
	colouredBody, 
	fullyColoured;

	public abstract State setFullAirport();

	public abstract State setColouredTails();

	public abstract State setColouredBody();

	public abstract State setFullyColoured();

	public abstract State setEmptyAirport();
}
