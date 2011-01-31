(ns week2.test-recursion
  (:use week2.recursion
        midje.sweet))

(facts "product"
       (product [])        => 1
       (product [1 2 3])   => 6
       (product [1 2 3 4]) => 24
       (product [0 1 2])   => 0
       (product #{2 3 4})  => 24)

(facts "last-element"
       (last-element [])      => nil
       (last-element [1 2 3]) => 3
       (last-element [2 5])   => 5)
