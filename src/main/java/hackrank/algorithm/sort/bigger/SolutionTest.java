package hackrank.algorithm.sort.bigger;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testFindGreaterWord() {

		assertNull( Solution.findGreaterWord( "aa" ) );
		assertNull( Solution.findGreaterWord( "cba" ) );
		assertNull( Solution.findGreaterWord( "ddddc" ) );

		assertEquals( "ba", Solution.findGreaterWord( "ab" ) );
		assertEquals( "baacde", Solution.findGreaterWord( "aedcba" ) );
		assertEquals( "hcdk", Solution.findGreaterWord( "dkhc" ) );
		assertEquals( "abacc", Solution.findGreaterWord( "aaccb" ) );
	}

}
