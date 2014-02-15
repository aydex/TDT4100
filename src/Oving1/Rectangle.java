package Oving1;

public class Rectangle {
	
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	public int height;
	public int width;
	
	public Rectangle() {
		this.x1 = 0;
		this.y1 = 0;
		this.x2 = 0;
		this.y2 = 0;
		this.height = 0;
		this.width = 0;
	}
	
	public int getMinX() {
		if (isEmpty()) {
			return 0;			
		} else if (this.x1 <= this.x2) {
			return this.x1;			
		} else {
			return this.x2;
		}
	}
	
	public int getMinY() {
		if (isEmpty()) {
			return 0;
		} else if (this.y1 <= this.y2) {
			return this.y1;			
		} else {
			return this.y2;
		}
	}
	
	public int getMaxX() {
		if (isEmpty()) {
			return 0;
		} else if (this.x1 <= this.x2) {
			return this.x2;			
		} else {
			return this.x1;
		}
	}
	
	public int getMaxY() {
		if (isEmpty()) {
			return 0;			
		} else if (this.y1 <= this.y2) {
			return this.y2;			
		} else {
			return this.y1;
		}	
	}
	
	public int getWidth() {
		if (isEmpty()) {
			return 0;
		}else if (this.x1 == this.x2) {
			this.width = 1;
			return 1;
		} else {
			this.width = Math.abs(getMinX()) + getMaxX() + 1;
			return this.width;
		}
	}
	
	public int getHeight() {
		if (isEmpty()) {
			return 0;
		} else if (this.y1 == this.y2) {
			this.height = 1;
			return 1;
		} else {
			this.height = Math.abs(getMinY()) + getMaxY() + 1;
			return this.height;
		}
	}
	
	public boolean isEmpty() {
		if (this.height == 0 || this.width == 0) {
			return true;
		} else {
			return false;			
		}
	}
	
	public boolean contains(int x, int y) {
		if (isEmpty()) {
			return false;
		} else if ((x >= getMinX() && x <= getMaxX()) && (y >= getMinY() && y <= getMaxY())) {
			return true;
		} else {
			return false;			
		}
	}
	
	public boolean contains(Rectangle rect) {
		return false;
	}
	
	public boolean add(int x, int y) {
		if (isEmpty()) {
			this.x1 = x;
			this.y1 = y;
			this.x2 = x;
			this.y2 = y;
			this.height = 1;
			this.width = 1;
			return true;
		} else if (contains(x,y) == false) {
			if (x < getMinX()) {
				this.x1 = x;
			} else if (x > getMaxX()) {
				this.x2 = x;
			}
			
			if (y < getMinY()) {
				this.y1 = y;
			} else if (y > getMaxY()) {
				this.y2 = y;
			}
			return true;
		} else {
			return false;			
		}
		
	}
	
	public boolean add(Rectangle rect) {
		if (rect.isEmpty()) {
			return false;
		} else if (isEmpty()) {
			this.x1 = rect.getMinX();
			this.y1 = rect.getMinY();
			this.x2 = rect.getMaxX();
			this.y2 = rect.getMaxY();
			this.height = 1;
			this.width = 1;
			this.height = getHeight();
			this.width = getWidth();
			return true;
		}  else {
			boolean returnval = false;
			if (this.x1 > rect.getMinX()){
				this.x1 = rect.getMinX();
				returnval = true;
			}
			if (this.y1 > rect.getMinY()) {
				this.y1 = rect.getMinY();
				returnval = true;
			}
			if (this.x2 < rect.getMaxX()) {
				this.x2 = rect.getMaxX();
				returnval = true;
			}
			if (this.y2 < rect.getMaxY()) {
				this.y2 = rect.getMaxY(); 
				returnval = true;
			}
			return returnval;
		}
	}
	
	public Rectangle union(Rectangle rect) {
		if (isEmpty()) {
			return rect;
		} else if (rect.isEmpty()){
			return this;
		} else {
			Rectangle newRect = new Rectangle();
			newRect.add(this);
			newRect.add(rect);
			/*if (newRect.add(this)) {
				if (this.x1 > rect.getMinX() && this.y1 > rect.getMinY()) {
					newRect.add(rect.getMinX(), rect.getMinY());
				}
				if (this.x2 < rect.getMaxX() && this.y2 < rect.getMaxY()) {
					newRect.add(rect.getMaxX(), rect.getMaxY());
				}
			} else {
				newRect.add(rect);
			}*/
			return newRect;
		}
	}
	
	public String toString() {
		return String.format("Top Left Coordinate is: [%s, %s] and Bottom Right Coordinate is: [%s, %s]", x1, y1, x2, y2);
	}
	
	public static void main(String[] args) {
		Rectangle rect = new Rectangle();
		System.out.println(rect.isEmpty());
		rect.add(1,1);
		System.out.println(rect);
		System.out.println(rect.isEmpty());
		System.out.println(rect.getHeight());
		System.out.println(rect.getWidth());
		System.out.println(rect.isEmpty());
		rect.add(3,3);
		System.out.println(rect);
		Rectangle rect2 = new Rectangle();
		rect2.add(1,4);
		rect2.add(-2,0);
		rect.add(rect2);
		System.out.println(rect2);
		System.out.println(rect);
	}

}
