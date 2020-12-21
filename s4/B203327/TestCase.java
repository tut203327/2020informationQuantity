package s4.B203327; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
import java.lang.*;
import s4.specification.*;
/*
interface FrequencerInterface {     // This interface provides the design for frequency counter.
    void setTarget(byte[]  target); // set the data to search.
    void setSpace(byte[]  space);  // set the data to be searched target from.
    int frequency(); //It return -1, when TARGET is not set or TARGET's length is zero
                    //Otherwise, it return 0, when SPACE is not set or Space's length is zero
                    //Otherwise, get the frequency of TAGET in SPACE
    int subByteFrequency(int start, int end);
    // get the frequency of subByte of taget, i.e target[start], taget[start+1], ... , target[end-1].
    // For the incorrect value of START or END, the behavior is undefined.
}
*/
/*
package s4.specification;
public interface InformationEstimatorInterface{
    void setTarget(byte target[]); // set the data for computing the information quantities
    void setSpace(byte space[]); // set data for sample space to computer probability
    double estimation(); // It returns 0.0 when the target is not set or Target's length is zero;
// It returns Double.MAX_VALUE, when the true value is infinite, or space is not set.
// The behavior is undefined, if the true value is finete but larger than Double.MAX_VALUE.
// Note that this happens only when the space is unreasonably large. We will encounter other problem anyway.
// Otherwise, estimation of information quantity, 
}                        
*/
public class TestCase {
    public static void main(String[] args) {
	int c;
	c = 0;
	try {
	    FrequencerInterface  myObject;
	    int freq,subfreq;
		    c = 0;
		System.out.println("checking Frequencer");
	    // This is smoke test
	    myObject = new Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
		if(4 != freq) {System.out.println("frequency() for Hi_Ho_Hi_Ho, should return 4, when target is H. But it returns "+freq); c++; }
		
		// Test case when target is not set
		myObject.setSpace("Hi Ho Hi Ho".getBytes());
		myObject.setTarget("".getBytes());
	    freq = myObject.frequency();
		if(-1 != freq) {System.out.println("frequency() for Hi_Ho_Hi_Ho, should return -1, when target is not set or length is zero. But it returns "+freq); c++; }
		
		// Test case subByteFrequency
		myObject = new Frequencer();
		myObject.setSpace("I do kinda consider these exercises should be way better explained".getBytes());
		myObject.setTarget("t".getBytes());
		freq = myObject.frequency();
		subfreq=myObject.subByteFrequency(0,20);
		if(1 != subfreq) {System.out.println("subByteFrequency() for 'I do kinda consider these exercises should be way better explained', should return 1, when target is t. But it returns "+subfreq); c++; }
 
		// Test case subByteFrequency values undefined
		myObject = new Frequencer();
		myObject.setSpace("Another test for frequency".getBytes());
		myObject.setTarget("t".getBytes());
		freq = myObject.frequency();
		subfreq=myObject.subByteFrequency(-1,300);
		if(1 != subfreq) {System.out.println("subByteFrequency() for 'Another test for frequency', should be undefined, when target is t. But it returns "+subfreq); c++; }
		
	}
	catch(Exception e) {
	    System.out.println("Exception occurred in Frequencer Object");
	    c++;
	}
	try {
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("checking InformationEstimator");
	    myObject = new InformationEstimator();
	    myObject.setSpace("3210321001230123".getBytes());
	    myObject.setTarget("0".getBytes());
	    value = myObject.estimation();
	    if((value < 1.9999) || (2.0001 <value)) { System.out.println("IQ for 0 in 3210321001230123 should be 2.0. But it returns "+value); c++; }
	    myObject.setTarget("01".getBytes());
	    value = myObject.estimation();
	    if((value < 2.9999) || (3.0001 <value)) { System.out.println("IQ for 01 in 3210321001230123 should be 3.0. But it returns "+value); c++; }
	    myObject.setTarget("0123".getBytes());
	    value = myObject.estimation();
	    if((value < 2.9999) || (3.0001 <value)) { System.out.println("IQ for 0123 in 3210321001230123 should be 3.0. But it returns "+value); c++; }
	    myObject.setTarget("00".getBytes());
	    value = myObject.estimation();
		if((value < 3.9999) || (4.0001 <value)) { System.out.println("IQ for 00 in 3210321001230123 should be 4.0. But it returns "+value); c++; }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred in InformationEstimator Object");
	    c++;
	}
	if(c == 0) { System.out.println("TestCase OK"); }
    }
}