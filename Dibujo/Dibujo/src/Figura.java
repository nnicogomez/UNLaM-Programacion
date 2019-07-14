public abstract class Figura {
		
		protected String color;
		
		public Figura(String str){
			color=str;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((color == null) ? 0 : color.hashCode());
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
			Figura other = (Figura) obj;
			if (color == null) {
				if (other.color != null)
					return false;
			} else if (!color.equals(other.color))
				return false;
			return true;
		}

		public abstract double calcularArea();
		public abstract double getArea();
		public abstract char getID();
		public abstract String toString();
}
