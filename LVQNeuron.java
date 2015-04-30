import java.util.Random;

//Representa neuronio
public class LVQNeuron
{
	public VectorNeural vector;
	double _class;
	
	// Random weights constructor
	public LVQNeuron(double _class) {
		Random random = new Random();
		double[] values = new double[DataSet.ATTRIB_COUNT];
		for (int i = 0; i < values.length; i++) {
			// Tem que ver se assim ta um random legal
			values[i] = random.nextDouble()*10;
		}
		
		// Set neuron class number
		this._class = _class;
		
		// Create vector with random values
		vector = new VectorNeural(values);
	}
	
	// Dataset constructor
	public LVQNeuron(double[] dataSetLine, int classAtributteIndex)
	{
		//TODO: Verificar se indice e valido
		this._class = dataSetLine[classAtributteIndex];
		
		//Cria novo arranjo removendo indice de classe
		double[] v = new double[dataSetLine.length - 1];
		for(int i = 0, j = 0; i < v.length && j < dataSetLine.length; i++)
		{
			if(j != classAtributteIndex)
			{
				v[i] = dataSetLine[j];
				j++;
			}
		}
		
		this.vector = new VectorNeural(v);	
	}
	
	//Calcula distancia com outra unidade
	public double distanceFrom(LVQNeuron n)
	{
		return this.vector.distanceFrom(n.vector, LVQ.DEFAULT_DISTANCE_METHOD);
	}
	
	//TODO: metodo de aproximar
	//TODO: metodo de distanciar
}