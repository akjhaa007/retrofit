package retrofit.learn.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import retrofit.learn.R;
import retrofit.learn.model.Box;

public class FaceAdapter extends RecyclerView.Adapter<FaceAdapter.ViewHolder>  {

    private Context context;
    private List<List<Box>> arrayList;


    public FaceAdapter(List<List<Box>> TempList, Context context) {

        this.arrayList = TempList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.row_list_tem, parent, false);


        //mRelative= (RelativeLayout)view.findViewById(R.id.mSnakRelate_listshop);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int viewType) {
        final Box v = (Box) arrayList.get(viewType);


        //holder.Confidence.setText(v.getConfidence ());
        holder.imgId.setText ( v.getImageId () );
        holder.mExteImgID.setText ( v.getExternalImageId () );
        holder.mFaceId.setText ( v.getFaceId () );



/*
        final  String title,course,cid,sub,uploaded,pdf,video,higlits,desc,em,Unit;
        title=v.getmTitle();
        course=v.getmCourseName();
        cid=v.getmCID();
        sub=v.getmSubjectName();
        uploaded=v.getmContentUpdateTime();
        pdf=v.getmPdfurl();
        video=v.getmVideoUrl();
        higlits=v.getmHiglights();
        desc=v.getmDescription();
        em=v.getmUserId();
        Unit=v.getmUnit();




        holder.content_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentlist1 = new Intent(context, YoutubeView.class);
                Bundle args = new Bundle();

                args.putString("t",title );
                args.putString("cid", cid);
                args.putString("h", higlits);
                args.putString("d", desc);
                args.putString("s", sub);
                args.putString("u", uploaded);
                args.putString("p", pdf);

                args.putString("v", video);
                args.putString("c", course);
                args.putString("unt", Unit);
                //args.putString("em", em);

                //  args.putString("cid", cid);
                intentlist1.putExtra("bundle", args);
                context.startActivity(intentlist1);

//context.startActivity(new Intent(context, YoutubeView.class));
            }
        });

*/
/*
        if (v.getmVerification().equals("0")) {
            holder.verification.setVisibility(View.VISIBLE);

        }

        if (v.getmVerification().equals("1")) {
            holder.verification.setVisibility(View.INVISIBLE);

        }

*/
        // Glide.with(context).load(v.getmImgUrl()).apply(RequestOptions.circleCropTransform()).into(holder.mStudprofile);


    }


    @Override
    public int getItemCount() {

        return arrayList.size();
    }




    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView mFaceId,mExteImgID,Confidence,imgId;
        RelativeLayout content_row;

        @SuppressLint("CutPasteId")
        ViewHolder(View list_item) {
            super(list_item);
            context = list_item.getContext();
            list_item.setOnClickListener(this);
            mFaceId=list_item.findViewById ( R.id.faceID );
            mExteImgID=list_item.findViewById ( R.id.ExtImageID );
            Confidence=list_item.findViewById ( R.id.Confidence );
            imgId=list_item.findViewById ( R.id.ImageID );



        }


        @Override
        public void onClick(View v) {

        }
    }
}