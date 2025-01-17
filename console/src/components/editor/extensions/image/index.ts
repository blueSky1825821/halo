import { ExtensionImage, VueNodeViewRenderer } from "@halo-dev/richtext-editor";
import ImageView from "./ImageView.vue";
import type { AxiosRequestConfig } from "axios";
import type { Attachment } from "@halo-dev/api-client";

interface UiImageOptions {
  uploadImage?: (
    file: File,
    options?: AxiosRequestConfig
  ) => Promise<Attachment>;
}

const Image = ExtensionImage.extend<UiImageOptions>({
  addOptions() {
    const { parent } = this;
    return {
      ...parent?.(),
      uploadImage: undefined,
    };
  },

  addAttributes() {
    return {
      ...this.parent?.(),
      file: {
        default: null,
      },
      width: {
        default: "100%",
        parseHTML: (element) => {
          const width =
            element.getAttribute("width") || element.style.width || null;
          return width;
        },
        renderHTML: (attributes) => {
          return {
            width: attributes.width,
          };
        },
      },
      height: {
        default: "100%",
        parseHTML: (element) => {
          const height =
            element.getAttribute("height") || element.style.height || null;
          return height;
        },
        renderHTML: (attributes) => {
          return {
            height: attributes.height,
          };
        },
      },
    };
  },

  addNodeView() {
    return VueNodeViewRenderer(ImageView);
  },
});

export default Image;
