package grid;

public class Cell {
	protected int _value;
	protected Shape _shape;
	protected Color _color;
	protected Police _police;
	protected boolean isSet;
	
	public Cell(){
		isSet = false;
	}
	
	public int get_value() {
		return _value;
	}
	public Color get_color() {
		return _color;
	}
	public Shape get_shape() {
		return _shape;
	}
	public Police get_police() {
		return _police;
	}
	public boolean get_isSet() {
		return isSet;
	}
	
	public void set_color(Color _color) {
		this._color = _color;
	}
	public void set_police(Police _police) {
		this._police = _police;
	}
	public void set_shape(Shape _shape) {
		this._shape = _shape;
	}
	public void set_value(int _value) {
		this._value = _value;
	}
	public void set_isSet(boolean isSet) {
		this.isSet=isSet;
	}
	
}
