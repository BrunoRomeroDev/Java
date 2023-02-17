package application;



public class Produto {

	private int id;
	private String name;
	public Double preco;
	public Double getPreco() {
		return preco;
	}
	public Double setPreco(Double preco) {
		return this.preco = preco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public Produto() {
		
	}
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", name=" + name + ", preco=" + preco + "]";
	}
	public Produto(int id, String name, Double preco) {
		super();
		this.id = id;
		this.name = name;
		this.preco = preco;
	}
	public void desconto() {
		 setPreco( this.preco*0.80);
	
	}
	
	public class tributos {
		
		Integer ICMS;
		Integer IPI;
		Double PIS;
		Double COFINS;
		public Integer getICMS() {
			return ICMS;
		}
		public void setICMS(Integer iCMS) {
			ICMS = iCMS;
		}
		public Integer getIPI() {
			return IPI;
		}
		public void setIPI(Integer iPI) {
			IPI = iPI;
		}
		public Double getPIS() {
			return PIS;
		}
		public void setPIS(Double pIS) {
			PIS = pIS;
		}
		public Double getCOFINS() {
			return COFINS;
		}
		public void setCOFINS(Double cOFINS) {
			COFINS = cOFINS;
		}
		public tributos(Integer iCMS, Integer iPI, Double pIS, Double COFINS) {
			super();
			ICMS = iCMS;
			IPI = iPI;
			PIS = pIS;
			COFINS = COFINS;
		}
		public tributos() {
			super();
		}
		@Override
		public String toString() {
			return "tributos [ICMS=" + ICMS + ", IPI=" + IPI + ", PIS=" + PIS + ", COFINS=" + COFINS + "]";
		}
		
		public Double calculo(Integer ICMS,Integer	IPI,Double	PIS,Double	COFINS) {
			Double result=0.0;
			
			class precalculo {
				
				Double CSLL;
				Double IRRPJ;
				public Double getCSLL() {
					return CSLL;
				}
				public void setCSLL(Double cSLL) {
					CSLL = cSLL;
				}
				public Double getIRRPJ() {
					return IRRPJ;
				}
				public void setIRRPJ(Double iRRPJ) {
					IRRPJ = iRRPJ;
				}
				public precalculo(Double CSLL, Double IRRPJ) {
					super();
					CSLL = CSLL;
					IRRPJ = IRRPJ;
				}
				@Override
				public String toString() {
					return "precalculo [CSLL=" + CSLL + ", IRRPJ=" + IRRPJ + "]";
				}
				
				public precalculo() {
				this.CSLL = 0.65;
				this.IRRPJ = 3.3;
				
				
				}
			}
			precalculo precalc = new precalculo();
			System.out.println(precalc);
			return result;
		}
		
	}
}
