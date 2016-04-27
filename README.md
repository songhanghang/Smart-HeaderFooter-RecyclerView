# SmartHeaderFooterRecyclerview
Easy implements Header &amp; Footer view, With least modification

## feature
Easy implements Header &amp; Footer view, With least modification

非常方便的实现Recyclerview添加HeaderView和FooterView，
* 1, No need change anyting with your target adapter

     不需要修改Target Adapter
* 2, Not destroy target adapter position

     不会破坏Target adapter中的 position (PS: 不需要 +1 -1)
* 3, Support dynamic add & remove

     支持动态添加移除
* 4, Support LinearLayoutManager & GridLayoutManager
 
    支持 LinearLayoutManager & GridLayoutManager 两种布局管理器

## screenshot
![Renderings](https://github.com/songhanghang/SmartHeaderFooterRecyclerview/blob/master/screenshot/hammerheadMRA58Nsonghang04252016170327.gif)

## usage

```java
      RecyclerView.Adapter targetAdapter = new RecyclerView.Adapter() { ... };
      GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
      SmartRecyclerAdapter smartRecyclerAdapter = new SmartRecyclerAdapter(targetAdapter, gridLayoutManager);
      smartRecyclerAdapter.setFooterView(footerView);
      smartRecyclerAdapter.setHeaderView(headerView);
      recyclerView.setAdapter(smartRecyclerAdapter);
```
