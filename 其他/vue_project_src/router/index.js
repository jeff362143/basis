import Vue from 'vue'
import VueRouter from 'vue-router'
import login from '../pages/login'
import home from '../pages/home'
import blogContentDetail from '../pages/blogContentDetail'
import blogEdit from '../pages/blogEdit'
// import messageBoard from '../pages/messageBoard'
import userHome from '../pages/userHome'
import adminLogin from '../pages/admin/adminLogin'
import adminHome from '../pages/admin/adminHome'
import userInfo from '../pages/admin/userInfo'
import adminUserMessage from '../pages/admin/adminUserMessage'
import userActions from '../pages/admin/userActions'
import userDetailActions from '../pages/admin/userDetailActions'
// import MyBlogDetails from '../pages/MyBlogDetails'
import register from '../pages/register'
import abbel from '../pages/admin/abbel'
import manageNews from '../pages/admin/manageNews'
import manageAllBlog from '../pages/admin/manageAllBlog'
import manageSite from '../pages/admin/manageSite'
import editNews from '../pages/admin/editNews'
import searchDetail from '../pages/searchDetail'
import userCenter from '../pages/userCenter'
import profile from '../pages/profile'
import myBlog from '../pages/myBlog'
import myColl from '../pages/myColl'
import myComment from '../pages/myComment'
import myFollow from '../pages/myFollow'
import followme from '../pages/followme'
import myLike from '../pages/myLike'
import recoBlog from '../pages/admin/recoBlog'
import blogExpert from '../pages/admin/blogExpert'
import blogManage from '../pages/admin/blogManage'
import myInform from '../pages/myInform'


// import test from '../pages/admin/test'
// import headerNav from '../components/headerNav'
// import blogContent from '../components/blogContent'




Vue.use(VueRouter);

export default new VueRouter({
  // 多个路由
  routes:[
       {
            // 这个path是上面的path是不一样的，它已经通过路由指向了login这个组件
            path:'/login',
            component:login
        },
        // {
        //     path:'/home',
        //     component:home
        // },
        {
            path:'/',
            component:home
        },
        {
            path:'/blogContentDetail',
            component:blogContentDetail
        },
        {
            path:'/blogEdit',
            component:blogEdit
        },

        {
            path:'/userHome',
            component:userHome
        },
        {
            path:'/adminLogin',
            component:adminLogin
        },
        {
            path:'/adminHome',
            component:adminHome,
            redirect:'recoBlog',
            children:[
                {
                    path:'/userInfo',
                    component:userInfo
                },
                {
                    path:'/adminUserMessage',
                    component:adminUserMessage
                },
                {
                    path:'/userActions',
                    component:userActions
                },
                {
                    path:'/userDetailActions',
                    component:userDetailActions
                },
                {
                    path:'/abbel',
                    component:abbel
                },
                {
                    path:'/manageNews',
                    component:manageNews
                },
                {
                    path:'/manageAllBlog',
                    component:manageAllBlog
                },
                {
                    path:'/manageSite',
                    component:manageSite
                },
                {
                    path:'/recoBlog',
                    component:recoBlog
                },
                {
                    path:'/blogExpert',
                    component:blogExpert
                },
                {
                    path:'/blogManage',
                    component:blogManage
                }
            ] 
        },
        {
            path:"/editNews",
            component:editNews
        },
        // {
        //         path:'/MyBlogDetails',
        //         component:MyBlogDetails
        // },
        {
                path:'/register',
                component:register
        },
        {
            path:'/searchDetail',
            component:searchDetail
        },
        {
            path:'/userCenter',
            component:userCenter,
            redirect:'profile',
            children:[
                {
                    path:'/profile',
                    component:profile
                },
                {
                    path:'/myBlog',
                    component:myBlog
                },
                {
                    path:'/myColl',
                    component:myColl
                },
                {
                    path:'/myComment',
                    component:myComment
                },
                {
                    path:'/myFollow',
                    component:myFollow
                },
                {
                    path:'/followme',
                    component:followme
                },
                {
                    path:'/myLike',
                    component:myLike
                },
                {
                    path:'/myInform',
                    component:myInform
                }
                // {
                //     path:'/messageBoard',
                //     component:messageBoard
                // }
            ]
        },
        
        



        /*  作为单独页面的组件才需要注册，然后可以渲染到App组件上，这两个公共组件不需要注册
        {
            path:'/headerNav',
            component:headerNav
        },
        {
            path:'blogContent',
            component:blogContent 
        }
        */
       
    ],

    
//   设置不同组件的滚动条不互相影响
    scrollBehavior(to, from, savedPosition){
        return { x: 0, y: 0 }
      }

})

const originalPush = VueRouter.prototype.push
   VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}


