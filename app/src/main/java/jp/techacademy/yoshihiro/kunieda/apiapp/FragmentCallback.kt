package jp.techacademy.yoshihiro.kunieda.apiapp

interface FragmentCallback {
    // Itemを押したときの処理
    fun onClickItem(url: String, id: String)

    // お気に入り追加時の処理
    fun onAddFavorite(shop: Shop)

    // お気に入り削除時の処理
    fun onDeleteFavorite(id: String)
}