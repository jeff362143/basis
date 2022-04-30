// pages/form/form.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    sports: [
      { name: "足球", value: "football" },
      { name: "蓝球", value: "basketball" },
      { name: "乒乓", value: "pingpang" },
    ],
    colors: ['red', 'green', 'blue']
  },
  showData(e) {
    console.log(e);
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (e) {
    console.log(23, e);
    console.log('form load');
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
    console.log('form show');

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    console.log('form hide');

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    console.log('form unload');

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