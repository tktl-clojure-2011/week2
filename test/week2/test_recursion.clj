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

(facts "sequence-contains?"
       (sequence-contains? 3 [1 2 3]) => true
       (sequence-contains? 3 [4 7 9]) => false
       (sequence-contains? :pony [])  => false)

(facts "seq="
       (seq= [1 2 4] '(1 2 4))  => true
       (seq= [1 2 3] [1 2 3 4]) => false
       (seq= [1 3 5] [])        => false)

(facts "power"
       (power 2 2)  => 4
       (power 5 3)  => 125
       (power 7 0)  => 1
       (power 0 10) => 0)
