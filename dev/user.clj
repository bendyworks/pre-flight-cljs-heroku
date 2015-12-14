(ns user
  (:require [reloaded.repl :refer [system reset stop]]
            [yourapp.system]))

(reloaded.repl/set-init! #'yourapp.system/create-system)
