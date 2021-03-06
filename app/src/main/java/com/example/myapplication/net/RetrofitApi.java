package com.example.myapplication.net;

import com.example.myapplication.bean.ArticleBean;
import com.example.myapplication.bean.BannerBean;
import com.example.myapplication.bean.BaseBean;
import com.example.myapplication.bean.CoinBean;
import com.example.myapplication.bean.DatasBean;
import com.example.myapplication.bean.FriendBean;
import com.example.myapplication.bean.HotKeyBean;
import com.example.myapplication.bean.NavigationBean;
import com.example.myapplication.bean.ProjectTreeBean;
import com.example.myapplication.bean.TreeBean;
import com.example.myapplication.bean.UserBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 作者：陈飞
 * 时间：2019/11/06 11:43
 */
public interface RetrofitApi {
    //首页列表
    @GET("article/list/{page}/json")
    Call<BaseBean<ArticleBean<DatasBean>>> mainList(
            @Path("page") int page);

    //首页banner
    @GET("banner/json")
    Call<BaseBean<List<BannerBean>>> banner();

    //常用网站
    @GET("friend/json")
    Call<BaseBean<List<FriendBean>>> friend();

    //搜索热词
    @GET("hotkey/json")
    Call<BaseBean<List<HotKeyBean>>> hotkey();

    //置顶文章
    @GET("article/top/json")
    Call<BaseBean<List<DatasBean>>> articleTop();

    //知识体系数据
    @GET("tree/json")
    Call<BaseBean<List<TreeBean>>> tree();

    //体系下的文章
    @GET("article/list/{page}/json")
    Call<BaseBean<ArticleBean<DatasBean>>> article(
            @Path("page") int page,
            @Query("cid") int cid);

    //导航数据
    @GET("navi/json")
    Call<BaseBean<List<NavigationBean<DatasBean>>>> navitation();

    //项目分类
    @GET("project/tree/json")
    Call<BaseBean<ProjectTreeBean>> projectTree();

    //项目列表数据
    @GET("project/list/{page}/json")
    Call<BaseBean<ArticleBean<DatasBean>>> projectList(
            @Path("page") int page,
            @Query("cid") int cid);

    //登录
    @POST("user/login")
    Observable<BaseBean<UserBean>> login(
            @Query("username") String username,
            @Query("password") String password);

    //注册
    @POST("user/register")
    Call<BaseBean<UserBean>> register(
            @Query("username") String username,
            @Query("password") String password,
            @Query("repassword") String repassword);

    //退出登录
    @GET("user/logout/json")
    Call<BaseBean<UserBean>> logout();

    //收藏文章列表
    @GET("lg/collect/list/{page}/json")
    Call<BaseBean<ArticleBean<DatasBean>>> collectList(
            @Path("page") int page);

    //收藏站内文章
    @POST("lg/collect/{id}/json")
    Call<BaseBean> collect1(
            @Path("id") int id);

    //收藏站外文章
    @POST("lg/collect/add/json")
    Call<BaseBean> collect2(
            @Query("title") String title,
            @Query("author") String author,
            @Query("link") String link);

    //文章列表取消收藏
    @POST("lg/uncollect_originId/{id}/json")
    Call<BaseBean> uncollect1(
            @Path("id") int id);

    //我的收藏页面取消收藏,originId列表页下发,无则为-1
    @POST("lg/uncollect/{id}/json")
    Call<BaseBean> uncollect2(
            @Path("id") int id,
            @Query("originId") int originId);

    //收藏网站列表
    @GET("lg/collect/usertools/json")
    Call<BaseBean<ArticleBean<DatasBean>>> colletWebList();

    //收藏网址
    @POST("lg/collect/addtool/json")
    Call<BaseBean> colletWeb(
            @Query("name") String name,
            @Query("link") String link);

    //编辑收藏网站
    @POST("lg/collect/updatetool/json")
    Call<BaseBean> updateColletWeb(
            @Query("id") int id,
            @Query("name") String name,
            @Query("link") String link);

    //删除收藏网站
    @POST("lg/collect/deletetool/json")
    Call<BaseBean> deleteColletWeb(
            @Query("id") int id);

    //搜索
    @POST("article/query/{page}/json")
    Call<BaseBean<ArticleBean<DatasBean>>> search(
            @Path("page") int page,
            @Query("k") String k);

    //积分排行榜
    @GET("coin/rank/{page}/json")
    Call<BaseBean<ArticleBean<CoinBean>>> coinRankList(
            @Path("page") int page);

    //获取个人积分
    @GET("lg/coin/getcount/json")
    Call<BaseBean<CoinBean>> coin();

    //获取个人积分列表
    @GET("lg/coin/list/{page}/json")
    Call<BaseBean<CoinBean>> coinList(
            @Path("page") int page);
}
