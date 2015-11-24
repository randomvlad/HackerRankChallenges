package hackrank.algorithm.implement.lane;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Service Lane Challenge
 * 
 * @see https://www.hackerrank.com/challenges/service-lane
 */
public class Solution {

	public static void main( String[] args ) {

		Scanner scanner = new Scanner( System.in );

		int serviceLaneLength = scanner.nextInt();
		int testCases = scanner.nextInt();

		List<Integer> serviceLaneUnits = new ArrayList<>( serviceLaneLength );
		for ( int i = 0; i < serviceLaneLength; i++ ) {
			serviceLaneUnits.add( scanner.nextInt() );
		}

		List<VehicleType> maxVehicleTypes = new ArrayList<>( testCases );
		for ( int i = 0; i < testCases; i++ ) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();

			int min = serviceLaneUnits.subList( start, end + 1 ).stream().min( Integer::compareTo ).get();

			maxVehicleTypes.add( VehicleType.valueOf( min ) );
		}

		scanner.close();

		for ( VehicleType type : maxVehicleTypes ) {
			System.out.println( type );
		}
	}
	
	public enum VehicleType {
		BIKE( 1 ), 
		CAR( 2 ), 
		TRUCK( 3 );
		
		private int type;

		private VehicleType( int type ) {
			this.type = type;
		}

		public int getType() {
			return type;
		}

		public String toString() {
			return String.valueOf( type );
		}

		public static VehicleType valueOf( int typeId ) {
			for ( VehicleType type : VehicleType.values() ) {
				if ( type.getType() == typeId ) {
					return type;
				}
			}

			throw new IllegalArgumentException( "Invalid vehicle type = " + typeId );
		}
	}

}
