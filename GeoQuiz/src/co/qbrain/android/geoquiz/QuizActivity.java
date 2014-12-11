package co.qbrain.android.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {

	private Button mTrueButton, mFalseButton;
	private ImageButton mPrevButton, mNextButton;
	private TextView mQuestionTextView;

	private TrueFalse[] mQuestionBank = new TrueFalse[] {
			new TrueFalse(R.string.question_oceans, true),
			new TrueFalse(R.string.question_mideast, false),
			new TrueFalse(R.string.question_africa, false),
			new TrueFalse(R.string.question_americas, true),
			new TrueFalse(R.string.question_asia, true),
			};
	private int mCurrentIndex = 0;

	private void updateQuestion() {
		int question = mQuestionBank[mCurrentIndex].getQuestion();
		mQuestionTextView.setText(question);
		}
	
	private void checkAnswer(boolean userPressedTrue){
		boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
		
		int messageResId = 0;
		
		if (userPressedTrue == answerIsTrue) {
			messageResId = R.string.correct_toast;
		} else {
			messageResId = R.string.incorrect_toast;
		}
		Toast.makeText(QuizActivity.this, messageResId, Toast.LENGTH_SHORT).show();
	}
	
	private View.OnClickListener vClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
			updateQuestion();
			}
		};

	private View.OnClickListener vClickListenerBack = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mCurrentIndex > 0) {
					mCurrentIndex = (mCurrentIndex - 1); // % mQuestionBank.length;
					}
				else {
					mCurrentIndex = mQuestionBank.length - 1;
					}
				updateQuestion();
				}
			};	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);

		mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
		mQuestionTextView.setOnClickListener(vClickListener);
		//int question = mQuestionBank[mCurrentIndex].getQuestion();
		//mQuestionTextView.setText(question);
		updateQuestion();
		
		mTrueButton = (Button)findViewById(R.id.true_button);
		mTrueButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			// ���� ������ �� ������, �� ����� �����!
				//Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
				checkAnswer(true);
				}
			});
		
		mFalseButton = (Button)findViewById(R.id.false_button);
		mFalseButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			// ���� ������ �� ������, �� ����� �����!
				//Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
				checkAnswer(false);
				}
			});
		mNextButton = (ImageButton)findViewById(R.id.next_button);
		mNextButton.setOnClickListener(vClickListener);
		mPrevButton = (ImageButton)findViewById(R.id.prev_button);
		mPrevButton.setOnClickListener(vClickListenerBack);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}

}
