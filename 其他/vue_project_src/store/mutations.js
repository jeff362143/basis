// 直接更新state的多个方法的对象
import{
   ADMIN_GETALLUSERINFO,
   Get_MESSAGE,
   RECEIVE_BLOGLIST,
   RECEIVE_BLOGS,
   RECEIVE_USERNAME,
   ADMIN_QUERYBYUSERNAME,
   GET_USERACTIONS,
   GET_USERBLOG,
   GET_MYCOLLBLOG,
   GET_COMMENTS,
   JUDGE_COLL,
   GET_USERINFO,
   JUDGE_REGISTER,
   COLL_BLOG,
   GET_NEWS,
   GET_ONEACTION,
   GET_ALLBLOGS,
   GET_SEARCHBLOGS,
   GET_BLOGDETAILS,
   GET_TODAYRECO,
   GET_EXPERT,
   JUDGE_FOLLOW,
   FOLLOWED_USER,
   JUDGE_LIKE,
   SHOW_LIKE,
   GET_USERLIKEBLOG,
   RECEIVE_SELFUSERINFO,
   RECEIVE_SELFCOMMENTS,
   RECEIVE_FOLLOWEDUSER,
   RECEIVE_MYBLOG,
   JUDGE_RECO,
   RECEIVE_RECOBLOG,
   RECEIVE_ADMIN,
   ADMIN_SET_RECO,
   DELETE_BLOG,
   RECEIVE_INFOCOUNT,
   RECEIVE_INFORM,
   RECEIVE_COMPLAINBLOGS
   // RECEIVE_FOLLOWEDMEUSER
} from './mutation-type'

export default{

  
   [RECEIVE_BLOGS](state,{blogContent}) {      //   获取分类博客
      state.blogContent = blogContent;
   },

  
   [RECEIVE_BLOGLIST](state,{blogList}) {     // 获取标签列表
      state.blogList = blogList;
   },

  
   [GET_NEWS](state,{news}) {      // 获取新闻详细
         // state.news = news.concat(news);
         state.news = news;
   },

   
   [GET_TODAYRECO](state,{todayReco}) {   // 获取首页的今日推荐
         state.todayReco = todayReco;
   },

   [GET_EXPERT](state,{expertInfo}) {
      state.expertInfo = expertInfo;
   },

   [RECEIVE_USERNAME](state,{username}) {    //  用户登录
      alert("登录成功，将跳往首页")
      localStorage.setItem("username",username);
      state.loginFlag = 1;
   },

      
   [JUDGE_REGISTER](state,{flag}) {    // 用户注册
         if(flag == true) {
            state.Flag =  !state.Flag ;
         }else{
            alert('该用户名已存在');
         }
      },

   // 根据用户名获取博客
   [GET_USERBLOG](state,{userBlog}) {
      state.userBlog = userBlog;
   },


   // 用户的收藏博客
   [GET_MYCOLLBLOG](state,{myCollBlog}) {
      state.userBlog = myCollBlog;
   },

   [GET_USERACTIONS](state,{userActions}) {
      state.userActions = userActions;
   },


       // 用户收藏与取消收藏博客
       [COLL_BLOG](state,{flag}) {
         if(flag == true) {
            state.collFlag = !state.collFlag;
         }
      },
   
         // 判断用户是否收藏博客
         [JUDGE_COLL](state,{collFlag}) {
            if(collFlag == true) {
               state.collFlag = !state.collFlag;
            }
         },

         [JUDGE_FOLLOW](state,{flag}) {
            if(flag == true) {
               state.followFlag = !state.followFlag;
            }
         },

         [FOLLOWED_USER](state,{flag}) {
            if(flag == true) {
               state.followFlag = !state.followFlag;
            }
         },

         // 判断点赞
         [JUDGE_LIKE](state,{LikeFlag}) {
            if(LikeFlag == true) {
               state.likeFlag = !state.likeFlag;
            }
         },
 
         // 点赞和取消点赞
         [SHOW_LIKE](state,{LikeFlag}) {
            if(LikeFlag == true) {
               state.likeFlag = !state.likeFlag;
            }
         },
         
         // 获取用户点赞过的博客
         [GET_USERLIKEBLOG](state,{userBlog}) {
            state.userBlog = userBlog;
         },

// *********************************************************个人中心
        [RECEIVE_SELFUSERINFO](state,{userSelfInfo}) {
            state.userSelfInfo = userSelfInfo[0];
        },

//  获取个人评论
    [RECEIVE_SELFCOMMENTS](state,{comments}) {
       state.blogComments = comments;
    },

//  根据用户名获取关注的人
    [RECEIVE_FOLLOWEDUSER](state,{user}) {
       state.followedUser = user;
    },

   //  根据用户名获取关注我的人
   // [RECEIVE_FOLLOWEDMEUSER](state,{user}) {
   //    state.followedUser = user;
   // },
// *******************************************************admin
   [ADMIN_GETALLUSERINFO](state,{userInfo}) {
      state.adminUserInfo = userInfo;
   },

   // 获取一个用户的动态信息
   [GET_ONEACTION](state,{action}) {
      state.userActions = action;
   },


   [RECEIVE_ADMIN](state,{flag}) {
      if(flag == true) {
         state.Flag = !state.Flag;
         localStorage.setItem("admin","admin");
      }else {
         alert('账号密码错误')
      }
   },

   [ADMIN_SET_RECO](state,{recoFlag}) {
      if(recoFlag == true) {
         state.recoFlag = !state.recoFlag;
      }
   },

   [DELETE_BLOG](state,{flag}) {
      if(flag == true) {
         state.Flag = !state.Flag;
      }
   },

   [RECEIVE_INFOCOUNT](state,{infoCount}) {
       state.infoCount = infoCount;
   },

   [RECEIVE_INFORM](state,{inform}) {
      state.inform = inform;
   },


   [RECEIVE_COMPLAINBLOGS](state,{blogs}) {
       state.blogContent = blogs;
   },










  

   [Get_MESSAGE](state,{result}) {
      state.adminUserMessage = result;
   },

   [ADMIN_QUERYBYUSERNAME](state,{userInfo}) {
      state.adminUserInfo = userInfo;
   },

  

   [GET_COMMENTS](state) {
      // state.blogDetail.comments = comments;
      state.loadFlag = !state.loadFlag;
   },


   // 获取用户个人博客数量和收藏博客数量
   [GET_USERINFO](state,{UserInfo}) {
      state.UserInfo = UserInfo;
   },





   // 获取一个用户的动态信息
   [GET_ONEACTION](state,{action}) {
      state.userActions = action;
   },

   // 保存全部用户博客到adminAllBlogs
   [GET_ALLBLOGS](state,{blogs}) {
      // var MardownIt = require("markdown-it");
      // var md = new MardownIt();
      // for(var i = 0; i < blogs.length; i++) {
      //      blogs[i].content = md.render(blogs[i].content)
      // }
      state.adminAllBlogs = blogs;
   },

   // 获取搜索博客
   [GET_SEARCHBLOGS](state,{blogs}) {
      state.searchBlogs = blogs;
   },
    

   [JUDGE_RECO](state,{Flag}) {
      if(Flag == true){
         state.recoFlag = !state.recoFlag;
      }
   },
 
   [RECEIVE_RECOBLOG](state,{blogs}) {
      state.blogContent = blogs;
   },













   // 改变state中的blogContent
   
    // 根据id获取的博客全部信息保存到 blogDetail:[]
    [GET_BLOGDETAILS](state,{blogDetails}) {
      var MardownIt = require("markdown-it");
      var md = new MardownIt();
      blogDetails.content = md.render(blogDetails.content)

       state.blogDetail = blogDetails;
    },
   
    [RECEIVE_MYBLOG](state,{blog}) {
        state.blogDetail = blog;
   }








}