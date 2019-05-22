FILESEXTRAPATHS_prepend_coral-dev := "${THISDIR}/${PN}:"

SRCBRANCH_coral-dev = "release-chef"
SRC_URI_coral-dev = "\
    git://coral.googlesource.com/uboot-imx;protocol=https;branch=${SRCBRANCH} \
    file://0002-ext4-cache-extent-blocks-during-file-reads.patch \
"
SRCREV_coral-dev = "49f436811a16f43dfbc1e84e0f836bbf79be8b47"

DEPENDS_coral-dev += "cora-boot-script"
