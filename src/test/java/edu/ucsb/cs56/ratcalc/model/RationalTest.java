package edu.ucsb.cs56.ratcalc.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RationalTest {

    private Rational r_5_15;
    private Rational r_24_6;
    private Rational r_3_7;  
    private Rational r_13_4;
    private Rational r_20_25;
    private Rational r_25_20;
    private Rational r_0_1; 
    
    @Before public void setUp() {
	r_5_15 = new Rational(5,15);
	r_24_6 = new Rational(24,6);
	r_3_7  = new Rational(3,7);
	r_13_4 = new Rational(13,4);
	r_20_25 = new Rational(20,25);
	r_0_1 = new Rational(0,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
	Rational r = new Rational(1,0);
    }
    
    @Test
    public void test_getNumerator_20_25() {
	assertEquals(4, r_20_25.getNumerator());
    }
    
    @Test
    public void test_getNumerator_13_4() {
	assertEquals(13, r_13_4.getNumerator());
    }
    
    @Test
    public void test_getDenominator_20_25() {
	assertEquals(5, r_20_25.getDenominator());
    }
    
    @Test
    public void test_getDenominator_13_4() {
	assertEquals(4, r_13_4.getDenominator());
    }

    @Test
    public void test_toString_5_15() {
	assertEquals("1/3",r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
	assertEquals("4",r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
	assertEquals("3/7",r_3_7.toString());
    }
    
    @Test
    public void test_toString_20_25() {
	assertEquals("4/5",r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
	assertEquals("0",r_0_1.toString());
    }

    @Test
    public void test_gcd_5_15() {
	assertEquals(5, Rational.gcd(5,15));
    }

    @Test
    public void test_gcd_15_5() {
	assertEquals(5, Rational.gcd(15,5));
    }

    @Test
    public void test_gcd_24_6() {
	assertEquals(6, Rational.gcd(24,6));
    }

    @Test
    public void test_gcd_17_5() {
	assertEquals(1, Rational.gcd(17,5));
    }
    
    @Test
    public void test_gcd_1_1() {
	assertEquals(1, Rational.gcd(1,1));
    }

    @Test
    public void test_gcd_20_25() {
	assertEquals(5, Rational.gcd(20,25));
    }

    @Test
    public void test_rational_m10_m5() {
	Rational r = new Rational(-10,-5);
	assertEquals("2",r.toString());
    }

    @Test
    public void test_rational_m5_6() {
	Rational r = new Rational(-5,6);
	assertEquals("-5/6",r.toString());
    }

    @Test
    public void test_rational_7_m8() {
	Rational r = new Rational(7,-8);
	assertEquals("-7/8",r.toString());
    }

    @Test
    public void test_r_5_15_times_r_3_7() {
	Rational r = r_5_15.times(r_3_7);
	assertEquals("1/7",r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
	Rational r = r_3_7.times(r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = r_m3_1.times(r_1_m3);
	assertEquals("1",r.toString());
    }

   @Test
    public void test_product_of_r_5_15_and_r_3_7() {
       Rational r = Rational.product(r_5_15,r_3_7);
       assertEquals("1/7",r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
	Rational r = Rational.product(r_3_7,r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = Rational.product(r_m3_1,r_1_m3);
	assertEquals("1",r.toString());
    }
 
    
    @Test
    public void test_lcm_5_15() {
	assertEquals(15, Rational.lcm(5,15));
    }

    @Test
    public void test_lcm_15_5() {
	assertEquals(15, Rational.lcm(15,5));
    }

    @Test
    public void test_lcm_24_6() {
	assertEquals(24, Rational.lcm(24,6));
    }

    @Test
    public void test_lcm_4_13() {
	assertEquals(52, Rational.lcm(4,13));
    }
    
    @Test
    public void test_lcm_6_6() {
	assertEquals(6, Rational.lcm(6,6));
    }

    Rational base = new Rational(1,1);
    Rational a1 = new Rational(4,1); 
    Rational b1 = new Rational(1,2); 
    Rational c1 = new Rational(0,1);
    Rational d1 = new Rational(1,1);
    Rational e1 = new Rational(-3,1);
    
    @Test
    public void test_plus_4() {
	Rational a = base.plus(a1);
	assertEquals("5", a.toString());
    }
    
    @Test
    public void test_plus_1_2() {
	Rational b = base.plus(b1);
	assertEquals("3/2",b.toString());
    }
    
    @Test
    public void test_plus_0() {
	Rational c = base.plus(c1);
	assertEquals("1", c.toString());
    }
    
    @Test
    public void test_plus_1() {
	Rational d = base.plus(d1);
	assertEquals("2", d.toString());
    }

    @Test
    public void test_plus_neg3() {
	Rational e = base.plus(e1);
	assertEquals("-2", e.toString());
    }

   @Test
    public void test_sum_of_r_5_15_and_r_3_7() {
       Rational r = Rational.sum(r_5_15,r_3_7);
       assertEquals("16/21",r.toString());
    }

   @Test
    public void test_sum_of_r_24_6_and_r_3_7() {
       Rational r = Rational.sum(r_24_6,r_3_7);
       assertEquals("31/7",r.toString());
    }


   @Test
    public void test_sum_of_r_20_25_and_r_0_1() {
       Rational r = Rational.sum(r_20_25,r_0_1);
       assertEquals("4/5",r.toString());
    }

   @Test
    public void test_sum_of_r_0_1_and_r_0_1() {
       Rational r = Rational.sum(r_0_1,r_0_1);
       assertEquals("0",r.toString());
    }

    @Test
    public void test_minus_4() {
	Rational a = base.minus(a1);
	assertEquals("-3", a.toString());
    }
    
    @Test
    public void test_minus_1_2() {
	Rational b = base.minus(b1);
	assertEquals("1/2",b.toString());
    }
    
    @Test
    public void test_minus_0() {
	Rational c = base.minus(c1);
	assertEquals("1", c.toString());
    }
    
   @Test
    public void test_difference_of_r_5_15_and_r_3_7() {
       Rational r = Rational.difference(r_5_15,r_3_7);
       assertEquals("-2/21",r.toString());
    }

   @Test
    public void test_difference_of_r_24_6_and_r_3_7() {
       Rational r = Rational.difference(r_24_6,r_3_7);
       assertEquals("25/7",r.toString());
    }


   @Test
    public void test_difference_of_r_20_25_and_r_0_1() {
       Rational r = Rational.difference(r_20_25,r_0_1);
       assertEquals("4/5",r.toString());
    }

   @Test
    public void test_difference_of_r_0_1_and_r_0_1() {
       Rational r = Rational.difference(r_0_1,r_0_1);
       assertEquals("0",r.toString());
    }

    @Test
    public void test_reciprocalOf_20_25() {
	Rational r = r_20_25.reciprocalOf();
	assertEquals("5/4",r.toString());
    }

    Rational g = new Rational(-13,1);
    Rational k = new Rational(13,-1);
    Rational l = new Rational(-13,-1);

    @Test
    public void test_reciprocalOf_13_n1() {
	Rational r = g.reciprocalOf();
	assertEquals(-1,r.getNumerator());
	assertEquals(13, r.getDenominator());
    }

    @Test(expected = ArithmeticException.class)
    public void test_reciprocalOf_0_1() {
	Rational r = r_0_1.reciprocalOf();
	}

    @Test
    public void test_reciprocalOfk() {
	Rational r = k.reciprocalOf();
	assertEquals("-1/13",r.toString());
    }
    
    @Test
    public void test_reciprocalOfl() {
	Rational r = l.reciprocalOf();
	assertEquals("1/13",r.toString());
    }

    @Test
    public void test_dividedBy_4() {
	Rational a = base.dividedBy(a1);
	assertEquals("1/4", a.toString());
    }
    Rational na1 = new Rational(-4,1);

    @Test
    public void test_dividedBy_n4() {
	Rational a = base.dividedBy(na1);
	assertEquals("-1/4", a.toString());
    }
    
    @Test
    public void test_dividedBy_1_2() {
	Rational b = base.dividedBy(b1);
	assertEquals("2",b.toString());
    }
    
    @Test (expected = ArithmeticException.class)
    public void test_dividedBy_0() {
	Rational c = base.dividedBy(c1);
    }
    
   @Test
    public void test_quotient_of_r_24_6_and_r_3_7() {
       Rational r = Rational.quotient(r_24_6,r_3_7);
       assertEquals("28/3",r.toString());
    }


   @Test(expected = ArithmeticException.class)
    public void test_quotient_of_r_20_25_and_r_0_1() {
       Rational r = Rational.quotient(r_20_25,r_0_1);
    }

   @Test
    public void test_quotient_of_na1_and_a1() {
       Rational r = Rational.quotient(na1,a1);
       assertEquals("-1",r.toString());
    }

   @Test
    public void test_quotient_of_na1_and_na1() {
       Rational r = Rational.quotient(na1,na1);
       assertEquals("1",r.toString());
    }
}
