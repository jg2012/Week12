import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.*;
import org.junit.jupiter.params.provider.MethodSource; 

class TestDemoTest {

	private TestDemo testDemo; 
	
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo(); 
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly( int a, int b, int expected, Boolean expectException) {
		
		
		if(!expectException) {
			  assertThat(TestDemo.addPositive(a, b)).isEqualTo(expected);
			} else {

		assertThatThrownBy(() -> 
	    TestDemo.addPositive(a, b))
	        .isInstanceOf(IllegalArgumentException.class);

	}
	}

	 static  Stream<Arguments> argumentsForAddPositive(){
		 //Formatter:off
		return Stream.of(
			
				arguments(-4,5,2, true),
				arguments(1,-3,8, true),
				arguments(0,5,6, true),
				arguments(10,0,3,true),
				arguments(-5,-8,-2, true), 
				arguments(0,0,0, true),
				arguments(2,4,6, false)
				); 
		//Formatter:on
	}		

	

	@Test
		void assertThatNumberSquaredIsCorrect() {
			TestDemo mockDemo = spy(testDemo);
			doReturn(5).when(mockDemo).getRandomInt();
			int fiveSquared = mockDemo.randomNumberSquared();
			
			assertThat(fiveSquared).isEqualTo(25);
		}

	
	 
}
