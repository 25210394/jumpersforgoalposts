// A class for recording individuals and inheritance for other classes

public abstract class Individual {

	// Attributes
	
	protected String name;
	protected int age;
	protected String pay;
	protected String employmentStatus;
	
	
	// Methods
	
	// Getter for name
	public String getName() {
		return name;
	}

	@Override
    public String toString() {
        return name; // or any other meaningful representation
    }

}
