package red.djh.wanandroid.api

import io.reactivex.Observable
import red.djh.wanandroid.bean.*
import red.djh.wanandroid.bean.site.ProjectBean
import red.djh.wanandroid.bean.site.ProjectTypeBean
import red.djh.wanandroid.network.RetrofitManager
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * red.djh.wanandroid.api
 *
 *
 * @author dengzi
 * @email denua@foxmail.com
 * @date 2019/8/1
 */
@Suppress("unused")
interface SiteApi {

    object Instance {
        val API = RetrofitManager.create(SiteApi::class.java)
    }

    @GET("project/list/{page}/json")
    fun getProjectList(@Query("cid") cid: Int, @Path("page") page: Int)
            : Observable<Response<PageBean<ProjectBean>>>

    @GET("/project/tree/json")
    fun getProjectTree(): Observable<Response<List<ProjectTypeBean>>>

    @GET("article/list/{page}/json")
    fun getArticles(@Path("page") page: Int): Observable<Response<PageBean<ArticleBean>>>
}