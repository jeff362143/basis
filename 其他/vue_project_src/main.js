import Vue from 'vue'
import App from './App'
import router from './router'
import elementui from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
import store from './store'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import mouse from '../static/js/mouseClick'
Vue.use(mouse)
Vue.use(mavonEditor)
Vue.use(elementui)


new Vue({
    el:'#test',
    components:{App},
    template:'<App/>',
    router,
    store
})
