package com.example.xin.dormitory.Student;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xin.dormitory.R;
import com.example.xin.dormitory.Utility.HttpUtil;
import com.example.xin.dormitory.Utility.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostsListActivity extends AppCompatActivity {
    private List<Posts> postList = new ArrayList<>();
    private FloatingActionButton fab_add;
    private FloatingActionButton fab_refresh;
    private RecyclerView postTitleRecyclerView;
    private PostAdapter adapter;
    private SwipeRefreshLayout swipeRefresh;
    private String ID;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_posts_list);

        initPost();

        fab_add = findViewById(R.id.fab_add);
        fab_refresh = findViewById(R.id.fab_refresh);
        SharedPreferences pref1 = getSharedPreferences("data", MODE_PRIVATE);
        ID = pref1.getString("ID", "");
        Toolbar toolbar_chat = findViewById(R.id.toolbar_chat);
        toolbar_chat.setTitle("");
        setSupportActionBar(toolbar_chat);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        swipeRefresh = findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshPosts();
            }
        });
        postTitleRecyclerView = findViewById(R.id.rv_posts_title);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        postTitleRecyclerView.setLayoutManager(layoutManager);
        adapter = new PostAdapter(postList);
        postTitleRecyclerView.setAdapter(adapter);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostsListActivity.this, AddPostsActivity.class);
                startActivity(intent);
            }
        });

        fab_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab_refresh.hide();
                postTitleRecyclerView.scrollToPosition(0);
                swipeRefresh.setRefreshing(true);
                refreshPosts();
            }
        });

        postTitleRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                RecyclerView.LayoutManager layoutManager1 = recyclerView.getLayoutManager();
                if(layoutManager1 instanceof LinearLayoutManager){
                    int firstItemPosition = ((LinearLayoutManager) layoutManager1).findFirstVisibleItemPosition();
                    if(firstItemPosition>1) {
                        fab_refresh.show();
                    }else{
                        fab_refresh.hide();
                    }
                }
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        initPost();
    }

    private void refreshPosts(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initPost();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initPost(){
        postList.clear();
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(HttpUtil.address + "getPosts.php").build();
//            String responseData = response.body().string();
            client.newCall(request).enqueue(new okhttp3.Callback(){
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MyApplication.getContext(),"服务器连接失败，无法获取信息",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String responseData = response.body().string();
                    try {
                        JSONArray jsonArray = new JSONArray(responseData);
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            Posts posts = new Posts();
                            posts.setImageId(R.drawable.portrait_s);
                            posts.setPublisherName(jsonObject.getString("name"));
                            posts.setPublisherID(jsonObject.getString("ID"));
                            String PostsDate = jsonObject.getString("PostsDate").substring(0,10);
                            String PostsTime = jsonObject.getString("PostsDate").substring(11,19);
                            posts.setPostDate(PostsDate + "\n" +"  "+PostsTime);
                            posts.setPostTitle(jsonObject.getString("postsTitle"));
                            posts.setPostsContent(jsonObject.getString("postsContent"));
                            posts.setPostsID(Integer.parseInt(jsonObject.getString("PostsID")));
                            posts.setLatestReplyTime(jsonObject.getString("LatestReplyTime"));
                            postList.add(0,posts);
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MyApplication.getContext(),"数据加载完成", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
        private List<Posts> mPostList;
        private Context mContext;

        class ViewHolder extends RecyclerView.ViewHolder {
            CircleImageView publisherImage;
            TextView publisherNickName;
            TextView postDate;
            TextView postTitle;
            View postsView;
            TextView replyTime;
            ImageButton imageBtDelete;

            public ViewHolder(View view) {
                super(view);
                postsView = view;
                publisherImage = view.findViewById(R.id.publisher_image);
                publisherNickName = view.findViewById(R.id.publisher_nickname);
                postDate = view.findViewById(R.id.post_date);
                postTitle = view.findViewById(R.id.post_title);
                replyTime = view.findViewById(R.id.reply_time);
                imageBtDelete = view.findViewById(R.id.image_bt_delete);
            }
        }

        public PostAdapter(List<Posts> postList) {
            this.mPostList = postList;
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
            if(mContext == null){
                mContext = parent.getContext();
            }
            View view = LayoutInflater.from(mContext).inflate(R.layout.posts_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            holder.postsView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    Posts posts = mPostList.get(position);
                    Intent intent = new Intent(v.getContext(), PostsChatActivity.class);
                    intent.putExtra("PostsID", ""+posts.getPostsID());
                    intent.putExtra("Title", posts.getPostTitle());
                    intent.putExtra("Content", posts.getPostsContent());
                    mContext.startActivity(intent);

                }
            });
            return holder;
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            final Posts posts = mPostList.get(position);
            holder.publisherImage.setImageResource(posts.getImageId());
            holder.publisherNickName.setText(posts.getPublisherName());
            holder.postDate.setText(posts.getPostDate());
            holder.postTitle.setText(posts.getPostTitle());
            holder.imageBtDelete.setOnClickListener(new View.OnClickListener() {
                String PostsID = ""+posts.getPostsID();
                @Override
                public void onClick(View v) {
                    AlertDialog alertDialog = new AlertDialog.Builder(PostsListActivity.this)
                            .setTitle("删除该帖子").setMessage("是否删除？")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    mPostList.remove(position);
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            adapter.notifyDataSetChanged();
                                        }
                                    });
                                    try {
                                        OkHttpClient client = new OkHttpClient();
                                        RequestBody requestBody = new FormBody.Builder().add("PostsID", PostsID).build();
                                        //服务器地址，ip地址需要时常更换
                                        String address = HttpUtil.address + "deletePosts.php";
                                        Request request = new Request.Builder().url(address).post(requestBody).build();
                                        client.newCall(request).enqueue(new okhttp3.Callback(){
                                            @Override
                                            public void onFailure(Call call, IOException e) {
                                                e.printStackTrace();
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Toast.makeText(MyApplication.getContext(),"服务器连接失败，无法删除",Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                            }
                                            @Override
                                            public void onResponse(Call call, Response response) throws IOException {
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Toast.makeText(MyApplication.getContext(),"删除成功！", Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                            }
                                        });
                                    }catch(Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    return;
                                }
                            }).create();
                    alertDialog.show();
                }
            });
            if((posts.getPublisherID()).equals(ID)){
                holder.imageBtDelete.setVisibility(ImageButton.VISIBLE);
            }else{
                holder.imageBtDelete.setVisibility(ImageButton.GONE);
            }
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentTime = formatter.format(new Date(System.currentTimeMillis()));
                Date d1 = formatter.parse(currentTime);
                Date d2 = formatter.parse(posts.getLatestReplyTime());
                String str;
                long time = (d1.getTime() - d2.getTime())/1000;
                if(time<60){
                    str = "回复于"+time+"秒前";
                }else if(time/60 < 60){
                    str = "回复于"+ (time/60+1) + "分钟前";
                }else if(time/3600 < 24){
                    str = "回复于"+(time/3600) +"小时前";
                }else if(time/86400 < 4){
                    str = "回复于"+ (time/86400) + "天前";
                }else{
                    str = "回复于"+ posts.getLatestReplyTime();
                }
                holder.replyTime.setText(str);
            }catch(ParseException e){
                e.printStackTrace();
            }
        }

        @Override
        public int getItemCount() {
            return mPostList.size();
        }
    }
}
