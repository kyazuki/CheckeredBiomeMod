# CheckeredBiomeMod
Buggy Biomes!

## 対応バージョン
Minecraft: 1.16.x<br>
Minecraft Forge: 32.0.0以上<br>
http://files.minecraftforge.net/maven/net/minecraftforge/forge/index_1.16.1.html

## 適用方法
ワールド新規作成画面から、その他のワールド設定->ワールドタイプを"チェッカー"に指定してください。<br>
マルチサーバーの場合は、強制的にワールドタイプが固定されます。

## 概説
バイオームがチャンク毎に変わります。<br>
同種のバイオームばかり出現するのを回避するために、<br>
一部バイオームは出現しないようになっています。(主に〇〇_HILLS)

## configファイル
Modを導入した状態で一回でも起動すると、configフォルダ内にcheckeredbiomemod-common.tomlが生成されます。<br>
値の変更は次回起動以降の**チャンク生成時**に適用されます。
- enable_nether_biome
  - オーバーワールドにおいて、ネザーのバイオームを生成するかどうか。<br>
    trueかfalseで指定でき、デフォルトはfalseです。
- enable_the_end_biome
  - オーバーワールドにおいて、エンドのバイオームを生成するかどうか。<br>
    trueかfalseで指定でき、デフォルトはfalseです。

## 注意点
- 特になし。
