package ED;

class No {
	    private Object no;
		private Object next;
		private Object prev;
	
	@Override
	public String toString() {
		return "Nó " + no + ", Próximo=" + next + ", Anterior=" + prev + "]";
	}


	   public No(Object no, Object prev, Object next) {
	      this.no = no;
	      this.prev = prev;
	      this.next = next;
	   }

	   public void setNo(Object no) {
	      this.no = no;
	   }

	   public void setNext(Object next) {
	       this.next = next;
	   }

	   public void setPrev(Object prev) {
	      this.prev = prev;
	   }

	   public Object getNo() {
	      return no;
	   }

	   public Object getPrev() {
	      return prev;
	   }

	   public Object getNext() {
	      return next;
	   }
	}