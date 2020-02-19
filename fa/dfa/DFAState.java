package fa.dfa;
import fa.State;

import java.util.HashMap;

/**
 * The DFAState is a child class of State. It contains the supported methods in
 * state while adding new functionality. A DFA contains at least one start and a
 * set of accepting states. A DFA State also has transitions to other states for
 * each alphabet symbol.
 * 
 * @author thomasreinking
 *
 */
public class DFAState extends State {

	/*
	 * Transition map, Character is input and state is where the transition goes to
	 */
	private HashMap<Character, DFAState> delta;
	private boolean acceptState; // boolean has default value of false

	/**
	 * Constructor for DFA State. Initilizes the variables of the name for the
	 * state, delta hashmap, boolean for acceptState, the acceptState is selected to
	 * be false if the constructor does not contain an argument to select the
	 * acceptState status.
	 * 
	 * @param name
	 *            Name for the DFA state
	 */
	public DFAState(String name) {
		this.name = name; // Get parent's variable of name and set it
		delta = new HashMap<Character, DFAState>();
	}

	/**
	 * Overloaded consturctor of DFA that accepts a boolean to indicate that this
	 * state could be selected to be an acceptState.
	 * 
	 * @param name
	 * @param acceptState
	 */
	public DFAState(String name, boolean acceptState) {
		this.name = name;
		this.acceptState = acceptState;
		delta = new HashMap<Character, DFAState>();
	}

	/**
	 * Returns whether the current DFA State is an accept state
	 * 
	 * @return Boolean of accept state status
	 */
	private boolean isAcceptState() {
		return acceptState;
	}

	/**
	 * Adds a transition to the current DFA state. This takes the argument for the
	 * symbol and the destination state and adds it to the hash map containing all
	 * transitions for the current state
	 * 
	 * @param symbol
	 *            Alphabet symbol used for transition
	 * @param destination
	 *            Destination state from given input
	 */
	public void addTransition(Character symbol, DFAState destination) {
		delta.put(symbol, destination);
	}

	/**
	 * Gets the destination state from given alphabet symbol on current DFA State
	 * 
	 * @return The DFA State that the symbol leads to
	 */
	public DFAState getDestination(Character symbol) {
		return delta.get(symbol);
	}
}
