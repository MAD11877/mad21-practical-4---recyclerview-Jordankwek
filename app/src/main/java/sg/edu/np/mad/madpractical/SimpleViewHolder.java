package sg.edu.np.mad.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class SimpleViewHolder extends RecyclerView.ViewHolder {
    TextView txt, txt1;
    ImageView image, bigimage;
    public SimpleViewHolder(View itemView){
        super(itemView);
        txt = itemView.findViewById(R.id.textView2);
        txt1 = itemView.findViewById(R.id.textView4);
        image = itemView.findViewById(R.id.imageView1);
        bigimage = itemView.findViewById(R.id.imageView2);

    }
}
