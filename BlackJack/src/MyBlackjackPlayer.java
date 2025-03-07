
/*
 * Define a blackjack player by inheriting from the superclass BlackjackPlayer
 *   and implementing the 3 abstract methods.
 */
//Azim Abdulmajeeth
// zwf8qy@virginia.edu
// HW 4 - Blackjack
// none
public class MyBlackjackPlayer extends BlackjackPlayer{
	@Override
	public int getBet() {
		if (this.handScore() == 16 && this.dealer.getVisibleCard().getRank() > 8) {// low chance of winning
			return 0;
		}
		else if (this.handScore() >= 12) {
			return 5;
		}
		else {
			return 10;
		}
	}

	@Override
	public Move getMove() {
		/* Hits until we get a score of 16 or better */
		if (this.handScore() == 10 || this.handScore() == 11) {// high chance of winning with either starting hand
			return Move.DOUBLE;
		}
		if(this.handScore() >= 16) {
			return Move.STAY;
		}
		else if(this.handScore() >= 13 && this.dealer.getVisibleCard().getRank() >= 2 && this.dealer.getVisibleCard().getRank() <= 6){
			return Move.STAY;
		}
		else if(this.handScore() == 12 && this.dealer.getVisibleCard().getRank() >= 4 && this.dealer.getVisibleCard().getRank() <= 6){
			return Move.STAY;
		}
		return Move.HIT;
	}

	@Override
	public void handOver(Card[] dealerHand) {
		/**
		 * If you care about looking at the dealer's hand once
		 * the hand is over, then you can do it here. This method
		 * is called automatically after every hand and a copy of the dealer's
		 * final hand is given to you to process. The dealer's hand will be
		 * found in the array of Cards that you pass when the method returns.
		 */

	}


}
