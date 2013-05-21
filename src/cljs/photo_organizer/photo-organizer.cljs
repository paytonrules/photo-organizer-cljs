(ns photo-organizer
  (:require [domina :as dom]
            [domina.css :as css]
            [goog.net.XhrIo :as xhr]
            [domina.events :as ev]))

(defn- receiver [event] 
  (let [response (.-target event)]
    (dom/append! (css/sel "#directories") (.getResponseText response))))

(defn init []
  (xhr/send "js/" receiver "GET"))

(set! (.-onload js/window) init)
