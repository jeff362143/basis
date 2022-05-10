import ajax from './ajax'

// 用户系统接口

export const GetBlogList = ()=>ajax('http://localhost:9999/Blog/userServlet',{"action": "getBlogList"});  // 获取首页博客分类列表

export const GetBlog = (tableName)=>ajax('http://localhost:9999/Blog/userServlet',{"action": "getBlog","json": tableName});   // 获取标记博客 

export const GetNews = ()=>ajax('http://localhost:9999/Blog/userServlet?action=getNews');  // 获取首页轮播新闻 

export const GetTodayReco=()=>ajax('http://localhost:9999/Blog/userServlet?action=getTodayReco');  // 获取首页的今日推荐

export const GetExpert=()=>ajax('http://localhost:9999/Blog/userServlet?action=getExpert'); // 获取专家列表

export const Login = (user)=>ajax('http://localhost:9999/Blog/userServlet?action=login',user,"post"); // 账号密码登录

export const register = (user)=>ajax('http://localhost:9999/Blog/userServlet?action=register',user,'post');  // 用户注册

export const GetUserBlogByUsername = (username)=>ajax('http://localhost:9999/Blog/userServlet',{"action": "getUserBlogByUsername","username":username}); // 查找一个用户的全部个人博客

export const GetUserLikeBlog=(username)=>ajax('http://localhost:9999/Blog/userServlet',{"action": "getUserLikeBlog","username": username}) // 获取用户点赞过的博客

export const GetMyCollBlog = (username)=>ajax('http://localhost:9999/Blog/userServlet',{"action": "getMyCollBlog","username":username});  // 根据用户名获取它的全部收藏博客

export const queryUserActionsByUsername =(username)=>ajax('http://localhost:9999/Blog/userServlet',{"action": "getOneUserAction","username":username}); // queryUserActionsByUsername获取一个用户的博客收藏数量等信息

export const JudgeFollow=(info)=>ajax('http://localhost:9999/Blog/userServlet',info); // 判断是否关注

export const FollowedUser=(info)=>ajax('http://localhost:9999/Blog/userServlet',info) // 关注和取消关注

export const Judgelike=(info)=>ajax('http://localhost:9999/Blog/userServlet',info) // 判断是否点赞

export const ShowLike=(info)=>ajax('http://localhost:9999/Blog/userServlet',info)  // 点赞和取消点赞

export const SendLikeInform = (inform)=>ajax("http://localhost:9999/Blog/userServlet?action=sendLikeInform",inform,"post");  // 点赞后发送消息给对方

export const DeleteComment = (commentId)=>ajax('http://localhost:9999/Blog/userServlet',commentId);  // 删除评论

export const judgeColl = (item)=>ajax('http://localhost:9999/Blog/userServlet',item);  // 根据博客唯一id判断博客是否被收藏

export const BlogColl = (item)=>ajax('http://localhost:9999/Blog/userServlet',item);  // 用户博客收藏与取消收藏

export const SaveBlog = (blog)=>ajax('http://localhost:9999/Blog/userServlet?action=userSaveBlog',blog,"post"); // 上传博客

export const updateBlog =(blog)=>ajax('http://localhost:9999/Blog/userServlet?action=userUpdateBlog',blog,'post'); // 更改用户blog

// *****************************个人中心
export const GetFollowedUser=(username)=>ajax('http://localhost:9999/Blog/userServlet',username);  // 根据用户名获取我关注的人和关注我的人

export const GetUserComment=(user)=>ajax('http://localhost:9999/Blog/userServlet',user); // 根据用户名获取它的全部评论

export const DeviseUserInfo=(userInfo)=>ajax('http://localhost:9999/Blog/userServlet?action=reviseUserInfo',userInfo,'post'); // 修改个人信息

export const GetUserInfo = (username)=>ajax('http://localhost:9999/Blog/userServlet',{"action":"getUserInfo","username":username}); // 个人中心的详细信息 

export const ReviseUserSelfDesc=(info)=>ajax('http://localhost:9999/Blog/userServlet',info);  //  修改个人签名 

export const SaveUserMessage = (message)=>ajax('http://localhost:9999/Blog/userServlet?action=saveMessage',message,"post");  // 上传用户留言

export const submitComment = (comment)=>ajax('http://localhost:9999/Blog/userServlet?action=saveComment',comment,'post'); // 提交评论

export const CompainReport=(info)=>ajax('http://localhost:9999/Blog/userServlet',info);   //  举报博客

export const Search=(value)=>ajax('http://localhost:9999/Blog/userServlet',{"action":"getSearchBlogs","value":value});  // 搜索功能

export const GetSelfInform = (username)=>ajax("http://localhost:9999/Blog/userServlet",{"action": "getSelfInform","username": username});  //  获取用户个人消息

export const GetInfoCount = (username)=>ajax('http://localhost:9999/Blog/userServlet',{"action": "getInfoCount","username":username});







// 公共api
export const DeleteBlog = (flag)=>ajax('http://localhost:9999/Blog/userServlet',flag);   //  删除博客

export const getBlogDetail=(blogId)=>ajax('http://localhost:9999/Blog/userServlet',blogId);// 获取博客详细信息（评论、点赞数等）











// 管理员端api

export const AdminLogin = (admin)=>ajax('http://localhost:9999/Blog/adminServlet?action=adminLogin',admin,"post");  // 管理员账号密码登录

export const addLabel =(label)=>ajax('http://localhost:9999/Blog/adminServlet',label); // addLabel新增标签

export const DeleteLabel = (labelName)=>ajax('http://localhost:9999/Blog/adminServlet',{"action":"deleteLabel","labelName":labelName});  // 删除标签

export const GetRecoBlog =(flag)=>ajax('http://localhost:9999/Blog/adminServlet',flag);    //  获取全部推荐或非推荐博客

export const UpdateExpert = (info)=>ajax('http://localhost:9999/Blog/adminServlet',info);   //  修改专家列表

export const GetMessage = (scope1,scope2,flag)=>ajax('http://localhost:9999/Blog/adminServlet',{"action":"getMessage","scope1":scope1,"scope2":scope2,"flag":flag}); // 获取用户留言

export const adminGetAllUserInfo = ()=>ajax('http://localhost:9999/Blog/adminServlet',{"action": "getAllUserInfo"});  // 获取全部用户个人信息 
// ********
export const getUserActions = ()=>ajax('http://localhost:9999/Blog/adminServlet',{"action": "getUserActions"});  // 获取用户动态信息

export const queryByUsername = (username)=>ajax('http://localhost:9999/Blog/adminServlet',{"action": "queryByUsername","username":username});  // 查找某一个用户个人信息

export const saveNewUserInfo = (userInfo)=>ajax('http://localhost:9999/Blog/adminServlet?action=saveNewUserInfo',userInfo,'post');  // 保存修改后的用户信息

export const ManageSite=()=>ajax('http://localhost:9999/Blog/adminServlet?action=manageSite');  // 获取全部举报信息

export const GetAllBlogs = ()=>ajax('http://localhost:9999/Blog/adminServlet?action=getAllBlogs');  // 获取数据库中全部博客内容

export const submitNews = (news)=>ajax('http://localhost:9999/Blog/adminServlet?action=saveNews',news,'post');  // 修改新闻信息

export const JudgeReco = (id)=>ajax('http://localhost:9999/Blog/adminServlet',id);   // 判断是否推荐

export const SetBlogReco = (flag)=>ajax('http://localhost:9999/Blog/adminServlet',flag); // 推荐和取消推荐





















// 废弃

// export const getAllComments = (id)=>ajax('http://localhost:9999/Blog/GetComments',{"id":id});  根据博客唯一id获取博客的全部评论内容








