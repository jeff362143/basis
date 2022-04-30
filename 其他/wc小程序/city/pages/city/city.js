// pages/city/city.js
let city = require('../../utils/city.js');
console.log(city);
Page({

  /**
   * 页面的初始数据
   */
  data: {
    // 城市列表
    cityList: [],
    // 热门城市
    hotCity: [],
    // 字母索引值列表
    searchLetter: [],
    // 历史记录列表
    historyCity: [],
    // 选中城市
    chooseCity: '--',
    // 窗口高度
    height: 0,
    // 字母高度
    letterHeight: 0,
    // 选中字母
    chooseLetter: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log('city load');

    // 定义窗口高度
    city.height = wx.getSystemInfoSync().windowHeight;
    // console.log(city.height)
    // 字母高度
    city.letterHeight = (city.height - 50) / city.searchLetter.length;
    // city.chooseLetter = "B";
   
    // 更新数据
    this.setData(city);
   
    // console.log(city.letterHeight);
  },
  chooseCity(e) {
    // console.log(e);
    // 更新数据
    this.setData({
      chooseCity: e.target.dataset.city
    })
  },
  chooseLetters(e) {
    // 更新数据
    this.setData({ chooseLetter: e.target.dataset.letter })
  },
  moveChooseLetter(e) {
    // 获取手指位置信息
    let y = e.touches[0].clientY - 50;
    // 计算位置
    let index = parseInt(y / this.data.letterHeight);
    // console.log(index);
    // 获取对应的字母
    let letter = this.data.searchLetter[index];
    // console.log(letter);
    // 当选中的字母与获取到的字母不同的时候，更新数据
    if (letter !== this.data.chooseLetter) {
      this.setData({ chooseLetter: letter  })
    }
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    console.log('city show');

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    console.log('city hide');

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})