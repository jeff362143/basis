import {
    RECEIVE_BLOGS, RECEIVE_BLOGLIST, RECEIVE_USERNAME,Get_MESSAGE,ADMIN_GETALLUSERINFO,ADMIN_QUERYBYUSERNAME,GET_USERACTIONS,
    GET_USERBLOG,GET_MYCOLLBLOG,GET_COMMENTS,JUDGE_COLL,GET_USERINFO,JUDGE_REGISTER,COLL_BLOG,GET_NEWS,GET_ONEACTION,GET_ALLBLOGS,
    GET_SEARCHBLOGS,GET_BLOGDETAILS,GET_TODAYRECO,GET_EXPERT,JUDGE_FOLLOW,FOLLOWED_USER,JUDGE_LIKE,SHOW_LIKE,GET_USERLIKEBLOG,
    RECEIVE_SELFUSERINFO,RECEIVE_SELFCOMMENTS,RECEIVE_FOLLOWEDUSER,RECEIVE_MYBLOG,JUDGE_RECO,RECEIVE_RECOBLOG,RECEIVE_ADMIN,
    ADMIN_SET_RECO,DELETE_BLOG,RECEIVE_INFOCOUNT,RECEIVE_INFORM,RECEIVE_COMPLAINBLOGS
} from './mutation-type'

import {GetBlog } from '../api'
import { GetBlogList } from '../api'
import { GetNews } from '../api'
import { GetTodayReco } from '../api'
import { GetUserBlogByUsername } from '../api'
import { JudgeFollow } from '../api'
import { FollowedUser } from '../api'
import { ShowLike } from '../api'
import { Judgelike } from '../api'
import { GetUserLikeBlog } from '../api'
// *****************************************个人中心
import { GetUserInfo } from '../api'
import { GetUserComment } from '../api'
import { GetFollowedUser } from '../api' 
import { submitNews } from '../api'
import { UpdateExpert } from '../api'
import { DeleteComment } from '../api'
import { JudgeReco } from '../api'
import { GetRecoBlog} from '../api'
import { AdminLogin } from '../api'
import { SetBlogReco } from '../api'
import { DeleteBlog } from '../api'
import { GetInfoCount } from '../api'
import { GetSelfInform } from '../api'
import { CompainReport } from '../api'
import { ManageSite } from '../api'
import { DeviseUserInfo } from '../api'



import { Login } from '../api'
import { SaveBlog } from '../api'
import { SaveUserMessage } from '../api'
import { GetMessage } from '../api'
import {adminGetAllUserInfo} from '../api'
import {queryByUsername} from '../api'
import {saveNewUserInfo} from '../api'
import {getUserActions} from '../api'
import {GetMyCollBlog} from '../api'
import {getBlogDetail} from '../api'
import { SendLikeInform } from '../api'
import { ReviseUserSelfDesc } from '../api'

//  获取博客全部评论内容
// import {getAllComments} from '../api'
// 提交用户评论
import {submitComment} from '../api'
// 判断该博客是否被收藏
import {judgeColl} from '../api'
// 获取用户博客和收藏博客数量
// import {getUserInfo} from '../api'
// 用户注册
import {register} from '../api'
//  博客收藏与取消收藏
import {BlogColl} from '../api'

// 修改个人博客
import {updateBlog} from '../api'
// 获取一个用户的动态信息
import {queryUserActionsByUsername} from '../api'
// 新增label
import {addLabel} from '../api'
// 删除label
import {DeleteLabel} from '../api'
// 获取全部博客
import {GetAllBlogs} from '../api'
// 搜索
import {Search} from '../api'
// 获取首页专家列表
import {GetExpert} from '../api'


export default {

    //  获取标记博客
    async getBlog({ commit },listName) {
        const result = await GetBlog(listName);
        if (result) {
            const blogContent = result.data;
            var MardownIt = require("markdown-it");
            var md = new MardownIt();
            for (var n in blogContent) {
            blogContent[n].content = md.render(blogContent[n].content)
            }
            commit(RECEIVE_BLOGS, { blogContent });
        } else { 
        }
    },

//  获取博客列表
    async getBlogList({ commit }) {
        const result = await GetBlogList();
        if(result) {
            const blogList = result.data;
            commit(RECEIVE_BLOGLIST,{ blogList })
        }else {
        }
     },

// 获取首页的轮播图新闻
async getNews({commit}) {
    const result = await GetNews();
    const news = result.data;
    commit(GET_NEWS,{news});
},

// 首页的今日推荐
async getTodayReco({commit}) {
    const result = await GetTodayReco();
    const todayReco = result.data;
    commit(GET_TODAYRECO,{todayReco});
},


// 获取首页专家
async getExpert({commit}) {
    const result = await GetExpert();
    const expertInfo = result.data;
    commit(GET_EXPERT,{expertInfo});
},

//  根据用户username获取用户全部博客
async getUserBlogByUsername({commit},username) {
    const result = await GetUserBlogByUsername(username);
        const userBlog = result.data;
        commit(GET_USERBLOG,{userBlog})
},

// 根据用户名获取用户所有收藏博客
async getMyCollBlog({commit},username){
        const result = await GetMyCollBlog(username);
        const myCollBlog = result.data;
        commit(GET_MYCOLLBLOG,{myCollBlog});
},

//  queryUserActionsByUsername获取一个用户动态
async queryUserActionsByUsername({commit},username) {
    const result = await queryUserActionsByUsername(username);
    const action = result.data;
    commit(GET_ONEACTION,{action})
},

//  判断是否收藏
async judgeColl({commit},item) {
    const result = await judgeColl(item);
    const collFlag = result.data;
    commit(JUDGE_COLL,{collFlag});
},

//  收藏或者取消收藏该博客
async collectBlog({commit},id) {
    const result = await BlogColl(id);
    const flag =  result.data;
    commit(COLL_BLOG,{flag});
},

// 判断是否关注
async judgeFollow({commit},info) {
    const result = await JudgeFollow(info);
    const flag = result.data;
    commit(JUDGE_FOLLOW,{flag});
},

// 关注和取消关注
async followedUser({commit},info) {
    const result = await FollowedUser(info);
    const flag = result.data;
    commit(FOLLOWED_USER,{flag});
},

// 根据id获取博客全部信息（评论，收藏，内容,点赞数等）
async getBlogDetailById({commit},blogId) {
    const result = await getBlogDetail(blogId);
    const blogDetails = result.data;
    commit(GET_BLOGDETAILS,{blogDetails});
},

// 点赞和取消点赞
async showLike({commit},info) {
    const result = await ShowLike(info);
    const LikeFlag = result.data;
    commit(SHOW_LIKE,{LikeFlag})
},

// 判断是否点赞
async judgeLike({commit},info) {
    const result = await Judgelike(info);
    const LikeFlag = result.data;
    commit(JUDGE_LIKE,{LikeFlag});
},

// userHome获取作者点赞博客
async getUserLikeBlog({commit},username) {
    const result = await GetUserLikeBlog(username);
    const userBlog = result.data;
    commit(GET_USERLIKEBLOG,{userBlog});
},

// 个人主页
// 根据用户名获取全部关注的人
async getFollowedUser({commit},username) {
    const result = await GetFollowedUser(username);
    const user = result.data;
    commit(RECEIVE_FOLLOWEDUSER,{user})
},










// 根据用户名获取用户信息（包括任职公司、专业、个性签名等详细个人信息）
async getUserSelfInfo({commit},username){
    const result = await GetUserInfo(username);
    const userSelfInfo = result.data;
    commit(RECEIVE_SELFUSERINFO,{userSelfInfo})
},

// 根据用户名获取评论
async getUserComment({commit},user) {
    const result = await GetUserComment(user);
    const comments = result.data;
    commit(RECEIVE_SELFCOMMENTS,{comments})
},



// 根据用户名获取关注他的所有人,RECEIVE_FOLLOWEDUSER使用两次
async getFollowedmeUser({commit},username) {
    const result = await GetFollowedUser(username);
    const user = result.data;
    commit(RECEIVE_FOLLOWEDUSER,{user})
},

// **********************************************************admin获取全部用户信息
// admin获取用户个人信息
async adminGetAllUserInfo({commit}) {
    const result = await adminGetAllUserInfo();
    const userInfo = result.data;
    commit(ADMIN_GETALLUSERINFO,{userInfo})
},

//  获取用户动态信息
async getUserActions({commit}) {
    const result = await getUserActions();
    const userActions = result.data;
    commit(GET_USERACTIONS,{userActions})
},

//  获取全部博客内容
async getAllBlog({commit}) {
    const result = await GetAllBlogs();
    const blogs = result.data;
    commit(GET_ALLBLOGS,{blogs});    
},


// 这个方法和getBlogDetailById一样，。。。。。
async getBlogByIdForEdit({commit},info) {
    const result = await getBlogDetail(info);
    const blog = result.data;
    commit(RECEIVE_MYBLOG,{blog});
},

async updateExpert({commit},info) {
    const result = await UpdateExpert(info);
    const message = result.data;
},

async deleteCommentById({commit},commentId) {
    const result = await DeleteComment(commentId);
    const message = result.data;
},



//  判断官方是否推荐
async judgeRecoById({commit},id) {
    const result = await JudgeReco(id);
    const Flag = result.data;
    commit(JUDGE_RECO,{Flag});
},

//  推荐和取消推荐博客
async recoBlog({commit},id) {
    const result = await RecoBlog(id);
},

async getRecoBlog({commit},flag) {
    const result = await GetRecoBlog(flag);
    const blogs = result.data;
    commit(RECEIVE_RECOBLOG,{blogs});
},

async adminLogin({commit},admin) {
    const result = await AdminLogin(admin);
    const flag = result.data;
    commit(RECEIVE_ADMIN,{flag});
},

async setBlogReco({commit},flag) {
    const result = await SetBlogReco(flag);
    const recoFlag = result.data;
    commit(ADMIN_SET_RECO,{recoFlag});
},

// 删除博客
async deleteBlog({commit},id) {
    const result = await DeleteBlog(id);
    const flag = result.data;
    commit(DELETE_BLOG,{flag});
},

// 获取用户未查看消息数量
async getInfoCount({commit},username) {
    const result = await GetInfoCount(username);
    const infoCount = result.data;
    commit(RECEIVE_INFOCOUNT,{infoCount});
},

// 个人通知
async getSelfInform({commit},username) {
    const result = await GetSelfInform(username);
    const inform = result.data;
    commit(RECEIVE_INFORM,{inform});
},

// 点击喜欢博客发送通知给博客主人
async sendLikeInform({commit},inform) {
    const result = await SendLikeInform(inform);
},

// 举报博客
async compainReport({commit},info) {
    const result = await CompainReport(info); 
},

async manageSite({commit}) {
    const result = await ManageSite();
    const blogs = result.data;
    commit(RECEIVE_COMPLAINBLOGS,{blogs});
},

async reviseUserSelfDesc({commit},info) {
    const result = await ReviseUserSelfDesc(info);
}, 















//  登录
     async Login( { commit },user ) {
         const result = await Login(user);
         if(result.data != "error") {
             const username = result.data;  //  后端返回的只是一个字符串，那么res.data就是字符串
             commit(RECEIVE_USERNAME,{username})
         }else {
             alert("账号或密码错误")
         }
     },

    //  用户注册
    async userRegister({commit},user) {
        const result = await register(user);
        var flag = result.data;
        commit(JUDGE_REGISTER,{flag});
    },

//  上传博客
    async SaveBlog( {commit},blog ) {
        const result = await SaveBlog(blog);
    },

//  上传留言
    async SaveUserMessage( {commit},message) {
        const result = await SaveUserMessage(message);
    },

// admin获取用户留言
    async GetMessage( {commit},scope) {
        var scope1,scope2 = "";
        var flag ="";
        if(scope) {
            scope1 = scope[0];
            scope2 = scope[1];
            flag = "true";
        }
        const message = await GetMessage(scope1,scope2,flag);
        const result = message.data;
        commit(Get_MESSAGE, {result} );
    },



// admin查找某一个用户
    async queryByUsername({commit},username) {
        const result = await queryByUsername(username);
        const userInfo = result.data;
        commit(ADMIN_QUERYBYUSERNAME,{userInfo})
    },

// admin修改新闻信息
    async saveNews({commit},news) {
        const result = await submitNews(news);
    },



//  新增标签
    async addLabel({commit},label) {
          const result = await addLabel(label);
    },

// 删除标签
    async deleteLabel({commit},labelName) {
          const result = await DeleteLabel(labelName);
    },








//  
    async saveNewUserInfo({commit},userInfo) {
        const result = await saveNewUserInfo(userInfo);
        alert("修改成功");
        location.reload();
    },







// 根据博客id获取博客的全部评论
    async getCommentsById({commit},id) {
        const result = await getAllComments(id); 
        const comments = result.data; 
        commit(GET_COMMENTS,{comments}); 
    },

//  提交用户评论
    async submitComment({commit},comment) {
        const result = await submitComment(comment);
        commit(GET_COMMENTS);
    },
    
    


//  获取用户个人博客数量和收藏博客的数量
    async getUserInfo({commit},username) {
        const result = await getUserInfo(username);
        const UserInfo = result.data;
        commit(GET_USERINFO,{UserInfo});
    },



//  获取新闻详细信息
    async getNewsDetail({commit}) {
        const result = await getNews();
        const news = result.data;
        commit(GET_NEWS,{news});
    },

// 用户编辑自己的博客 
    async updateBlog({commit},blog) {
        const result = await updateBlog(blog);
    },

//  简单的搜索功能
    async search({commit},value) {
        const result = await Search(value);
        const blogs = result.data;
        commit(GET_SEARCHBLOGS,{blogs});
    },









// 根据id获取博客全部信息（评论，收藏，内容）
async getBlogDetailById({commit},blogId) {
    const result = await getBlogDetail(blogId);
    const blogDetails = result.data;
    commit(GET_BLOGDETAILS,{blogDetails});
},


// 
async deviseUser({commit},userInfo) {
    const result = await DeviseUserInfo(userInfo);
}











}// export default 专属








