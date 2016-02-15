package org.TestCases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@SuppressWarnings("javadoc")
@RunWith(Suite.class)
@SuiteClasses(
{ TestMyAccount.class, TestAddToCart.class, MyAccountLogIn.class })
public class FTestSuite
{
}
