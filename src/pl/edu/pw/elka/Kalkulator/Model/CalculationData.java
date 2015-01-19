/**
 * 
 */
package pl.edu.pw.elka.Kalkulator.Model;

/**
 * klasa z metodami obliczeñ
 * 
 * @author Tomasz Jakubczyk
 */
class CalculationData
{
	private String str;

	/**
	 * konstruktor danych matematycznych
	 * 
	 * @param str
	 */
	CalculationData(final String str)
	{
		this.str = str;
	}

	/** obliczy wynik */
	String Calculate()
	{
		while(!isNum(this.str))
		{
			this.FindAndCalc();
		}
		return this.str;
	}

	/** znajdzie i wykona pierwsze dostêpne dzia³anie */
	private void FindAndCalc()
	{
		/** kolejnoœæ wykonywania dzia³añ */
		int index1 = this.str.indexOf('(');
		if(index1 != -1)
		{
			this.Klamry(index1);
		}
		else
		{
			index1 = this.str.indexOf('*');
			int index2 = this.str.indexOf('/');
			if(((index1 != -1) && (index2 == -1))
					|| ((index1 != -1) && (index2 > index1)))
			{
				this.Mnozenie(index1);
			}
			else if(index2 != -1)
			{
				this.Dzielenie(index2);
			}
			else
			{
				index1 = this.str.indexOf('+');
				index2 = this.str.indexOf('-');
				if((index1 <= index2 && index1 != -1)
						|| (index1 != -1 && index2 == -1))
				{
					this.Dodawanie(index1);
				}
				else if(index2 != -1)
				{
					this.Odejmowanie(index2);
				}
			}
		}
	}

	/**
	 * odejmij
	 * 
	 * @param index1
	 *            pozycja -
	 */
	private void Odejmowanie(final int index1)
	{
		int poczatekLewego = this.LewyOperand(index1);
		int koniecPrawego = this.PrawyOperand(index1);
		if(poczatekLewego != index1)
		{
			this.str = this.str.substring(0, poczatekLewego)
					+ Double.toString(Double.parseDouble(this.str.substring(
							poczatekLewego, index1))
							- Double.parseDouble(this.str.substring(index1 + 1,
									koniecPrawego)))
					+ this.str.substring(koniecPrawego, this.str.length());
		}
		else
		{
			char c1 = this.str.charAt(poczatekLewego);
			char c2 = this.str.charAt(poczatekLewego + 1);
			if(c1 == '+' && c2 == '-')
			{
				this.str = this.str.substring(1);
			}
			else if(c1 == '-' && c2 == '-')
			{
				this.str = this.str.substring(2);
			}
		}

	}

	/**
	 * dodaj
	 * 
	 * @param index1
	 *            + poz
	 */
	private void Dodawanie(final int index1)
	{
		int poczatekLewego = this.LewyOperand(index1);
		int koniecPrawego = this.PrawyOperand(index1);
		this.str = this.str.substring(0, poczatekLewego)
				+ Double.toString(Double.parseDouble(this.str.substring(
						poczatekLewego, index1))
						+ Double.parseDouble(this.str.substring(index1 + 1,
								koniecPrawego)))
				+ this.str.substring(koniecPrawego, this.str.length());
	}

	/**
	 * podziel
	 * 
	 * @param index1
	 *            /poz
	 */
	private void Dzielenie(final int index1)
	{
		int poczatekLewego = this.LewyOperand(index1);
		int koniecPrawego = this.PrawyOperand(index1);
		this.str = this.str.substring(0, poczatekLewego)
				+ Double.toString(Double.parseDouble(this.str.substring(
						poczatekLewego, index1))
						/ Double.parseDouble(this.str.substring(index1 + 1,
								koniecPrawego)))
				+ this.str.substring(koniecPrawego, this.str.length());
	}

	/**
	 * pomnó¿
	 * 
	 * @param index1
	 *            *poz
	 */
	private void Mnozenie(final int index1)
	{
		int poczatekLewego = this.LewyOperand(index1);
		int koniecPrawego = this.PrawyOperand(index1);
		this.str = this.str.substring(0, poczatekLewego)
				+ Double.toString(Double.parseDouble(this.str.substring(
						poczatekLewego, index1))
						* Double.parseDouble(this.str.substring(index1 + 1,
								koniecPrawego)))
				+ this.str.substring(koniecPrawego, this.str.length());
	}

	/**
	 * zwraca pozycjê koñca prawego operandu
	 * 
	 * @param index1
	 * @return int
	 */
	private int PrawyOperand(final int index1)
	{
		for(int i = index1 + 1; i < this.str.length(); i++)
		{
			char c = this.str.charAt(i);
			if(c == '+' || (c == '-' && i > index1 + 1) || c == '*' || c == '/')
			{
				return i;
			}
		}
		return this.str.length();
	}

	/**
	 * zwraca pozycje pocz¹tka lewego operandu
	 * 
	 * @param index1
	 * @return int
	 */
	private int LewyOperand(int index1)
	{
		for(int i = index1 - 1; i >= 0; i--)
		{
			char c = this.str.charAt(i);
			if(c == '+' || c == '-' || c == '*' || c == '/')
			{
				return i + 1;
			}
		}
		return 0;
	}

	/**
	 * wylicza wyra¿enie w klamrach
	 * 
	 * @param index1
	 *            pozycja klamry otwieraj¹cej
	 */
	private void Klamry(final int index1)
	{
		int i = index1 + 1;
		int lewa = 1;
		int prawa = 0;
		do
		{
			if(this.str.charAt(i) == '(')
			{
				lewa++;
			}
			if(this.str.charAt(i) == ')')
			{
				prawa++;
			}
			i++;
		} while(i < this.str.length() && lewa != prawa);
		if(this.str.length() > index1 + 1)
		{
			this.str = this.str.substring(0, index1)
					+ (new CalculationData(str.substring(index1 + 1, i - 1)))
							.Calculate()
					+ this.str.substring(i, this.str.length());
		}
	}

	/**
	 * czy napis jest liczb¹
	 * 
	 * @param strNum
	 *            napis
	 * @return bool
	 */
	private boolean isNum(String strNum)
	{
		boolean ret = true;
		try
		{
			Double.parseDouble(strNum);
		}
		catch(NumberFormatException e)
		{
			ret = false;
		}
		return ret;
	}
}
