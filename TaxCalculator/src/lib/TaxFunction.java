package lib;

/**
 * A calculator to calculate the amount of income tax that an employee must pay annually.
 * 
 * The tax is calculated as 5% of the net annual income (monthly salary and other monthly income multiplied by the number of working months minus deductions) minus the non-taxable income.
 * 
 * If the employee is unmarried and has no children, then the non-taxable income is Rp 54,000,000.
 * If the employee is married, the non-taxable income is increased by Rp 4,500,000.
 * If the employee has children, the non-taxable income is increased by Rp 4,500,000 per child up to the third child.
 */

 
public class TaxCalculator {
    private static final int NON_TAXABLE_INCOME_SINGLE = 54000000;
    private static final int NON_TAXABLE_INCOME_MARRIED = 58500000;
    private static final int NON_TAXABLE_INCOME_PER_CHILD = 1500000;
    private static final double TAX_RATE = 0.05;

    /**
     * Calculate the non-taxable income of an employee based on their marital status and number of children.
     *
     * @param isMarried Whether the employee is married.
     * @param numberOfChildren The number of children the employee has.
     * @return The amount of non-taxable income.
     */
    private static int calculateNonTaxableIncome(boolean isMarried, int numberOfChildren) {
        int nonTaxableIncome = isMarried ? NON_TAXABLE_INCOME_MARRIED : NON_TAXABLE_INCOME_SINGLE;
        if (numberOfChildren > 0) {
            int additionalNonTaxableIncome = Math.min(3, numberOfChildren) * NON_TAXABLE_INCOME_PER_CHILD;
            nonTaxableIncome += additionalNonTaxableIncome;
        }
        return nonTaxableIncome;
    }

	public static int TaxCalculator(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		int nonTaxableIncome = calculateNonTaxableIncome(isMarried, numberOfChildren);
		int annualIncome = ((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible;
		int taxableIncome = annualIncome - nonTaxableIncome;
		int incomeTax = (int) Math.round(taxableIncome * TAX_RATE);
		return Math.max(incomeTax, 0);
	}

    /**
     * Calculate the net annual income of an employee based on their monthly salary, other monthly income, number of working months, and deductions.
     *
     * @param monthlyIncome The employee's monthly income (including salary and other income).
     * @param numberOfMonthWorking The number of months the employee has worked in a year.
     * @param deductible The amount of deductible expenses.
     * @return The employee's net annual income.
     */
    
}