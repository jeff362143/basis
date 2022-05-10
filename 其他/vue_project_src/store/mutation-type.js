// 包含n个mutation的type名称常量
export const RECEIVE_BLOGS = 'receive_blogs'
export const RECEIVE_BLOGLIST = 'receive_bloglist'
export const RECEIVE_USERNAME = 'receive_username'

// 管理系统
export const Get_MESSAGE = 'getMessage'
export const ADMIN_GETALLUSERINFO = 'adminGetAllUserInfo'
export const ADMIN_QUERYBYUSERNAME = 'queryByUsername'
export const GET_USERACTIONS = 'getUserActions'
export const GET_USERBLOG = 'getUserBlog'

// 获取我的收藏博客
export const GET_MYCOLLBLOG = 'getMyCollBlog'

// 获取博客全部评论
export const GET_COMMENTS = 'getComments'

// 判断该博客是否收藏
export const JUDGE_COLL = 'judgeColl'

// 获取用户个人博客数量和收藏博客数量
export const GET_USERINFO = "getUserInfo"

// 用户注册
export const JUDGE_REGISTER = "judgeRegister"

// 收藏博客与取消收藏
export const COLL_BLOG = "collBlog"

// 获取新闻信息
export const GET_NEWS = 'getNews'

// 根据用户名返回一个用户的动态信息
export const GET_ONEACTION = 'getOneAction'

// 保存全部博客
export const GET_ALLBLOGS = "getAllBlogs";

// 搜索
export const GET_SEARCHBLOGS = "getSearchBlogs";

// 根据id获取博客的全部信息，，，
export const GET_BLOGDETAILS = "getBlogDetails";

// 后台获取首页推荐内容传给vuex
export const GET_TODAYRECO = 'getTodayReco';

// 获取首页专家列表
export const GET_EXPERT = "getExpert";

// 判断关注
export const JUDGE_FOLLOW = "judgeFollow";

// 关注和取消关注
export const FOLLOWED_USER = "FollowedUser";

// 判断点赞
export const JUDGE_LIKE = "JudgeLike";

// 点赞和取消点赞
export const SHOW_LIKE = "showLike";

// 获取用户点赞过的博客
export const GET_USERLIKEBLOG = "getUserLikeBlog";

// ***********************************************************************个人中心
// 获取个人信息
export const RECEIVE_SELFUSERINFO = "receiveSelfUserInfo";

// 获取个人评论
export const RECEIVE_SELFCOMMENTS = "receiveSelfComments";

// 获取关注的人
export const RECEIVE_FOLLOWEDUSER = "receiveFollowedUser";

// 获取关注我的人
// export const RECEIVE_FOLLOWEDMEUSER = "receiveFollowedMeUser";

export const RECEIVE_MYBLOG = "receiveMyBlog";

export const JUDGE_RECO = "judgeReco";

export const RECEIVE_RECOBLOG = "receiveRecoBlog";

export const RECEIVE_ADMIN = "receiveAdmin";

export const ADMIN_SET_RECO = "adminSetReco";

export const DELETE_BLOG = "deleteBlog";

export const RECEIVE_INFOCOUNT = "receiveInfoCount";

export const RECEIVE_INFORM = "receiveInform";

export const RECEIVE_COMPLAINBLOGS = "receiveComplainBlogs";