package ED; 

class No {
	public long item;
	public No dir;
	public No esq;
	
	public long getItem() {
		return item;
	}
	public void setItem(long item) {
		this.item = item;
	}
	public No getDir() {
		return dir;
	}
	public void setDir(No dir) {
		this.dir = dir;
	}
	public No getEsq() {
		return esq;
	}
	public void setEsq(No esq) {
		this.esq = esq;
	}
	@Override
	public String toString() {
		return "No [item=" + item + ", dir=" + dir + ", esq=" + esq + "]";
	}
}
