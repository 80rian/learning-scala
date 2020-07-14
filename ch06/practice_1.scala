// 1) Create a list of the first 20 odd Long numbers. 
// Can you create this with a for-loop, with the filter operation, and with the map operation? 
// What’s the most efficient and expressive way to write this?


// for
val oddListFor = for (i <- 1L to 40L if i % 2 == 1) yield i

// filter
val oddListFilter = 1L to 40L filter ( _ % 2 == 1 )

// map
val oddListMap = 1L to 20L map ( _ * 2 - 1 )